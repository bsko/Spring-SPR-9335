package ru.bsc.alfa.protocol.transformer;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
//import ru.bsc.alfa.jmb.base.exception.ErrorCode;
//import ru.bsc.alfa.jmb.base.exception.JMBException;
import ru.bsc.alfa.protocol.back.OperationMapping;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * User: ykhrustalev
 * Date: 22.03.12
 */

public class RequestParser {

  final private static Logger logger = LoggerFactory.getLogger(RequestParser.class);
  public static final String SERVICE_BUNDLE_NAME = "jmb-protocol-service";
  
  private JMBPSerializer jmbpSerializer;
  private OperationMapping operationMapping;

  public void parse(Exchange exchange) {

    Double actualVersion = new Double((String) exchange.getIn().getHeader(ResponsePublisher.JMBP_VERSION));
    String protocolService = (String) exchange.getIn().getHeader(SERVICE_BUNDLE_NAME);
    
    long start = System.currentTimeMillis();
    logger.debug("Started parsing request");

    String jsonString = exchange.getIn().getBody(String.class);

    logger.trace("Received JSON request: " + jsonString);

    try {

      ProtocolObject protocolObject = jmbpSerializer.deSerialize(jsonString, ProtocolObject.class, actualVersion);

      if(!protocolObject.getOperationId().startsWith(protocolService)) {
        logger.error("Requested protocol operation ["+protocolObject.getOperationId()+" doesn't match requested service ["+protocolService+"]");
      }

      MDC.put("command", "CMD:" + protocolObject.getOperationId());

      Class<? extends ProtocolObject> clazz = operationMapping.getType(protocolObject.getOperationId());
      if(clazz == null) {
        logger.error("Can't find protocol operation for " + protocolObject.getOperationId());
      }

      ProtocolObject result = jmbpSerializer.deSerialize(jsonString, clazz, actualVersion);

      logger.debug("Finished parsing request: " + (System.currentTimeMillis() - start) + " ms spent");
      logger.debug("Using camel URI: " + result.getOperationId());

      exchange.getIn().setHeader("jmbCamelURI", result.getOperationId().split(":")[1]);
      exchange.getIn().setHeader("jmba_request_command", result.getOperationId());
      exchange.getIn().setBody(result);
    } catch (Throwable t) {
      logger.error("Error while parsing JMBP request: probably malformed JSON encountered:\n" + jsonString, t);
//      throw new JMBException("Malformed JMBP request", ErrorCode.JMBP_ISSUE);
    }


  }

  public void setJmbpSerializer(JMBPSerializer jmbpSerializer) {
    this.jmbpSerializer = jmbpSerializer;
  }

  public void setOperationMapping(OperationMapping operationMapping) {
    this.operationMapping = operationMapping;
  }
}
