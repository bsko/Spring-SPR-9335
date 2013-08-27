package ru.bsc.mbs.jmba.protocol.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import ru.bsc.mbs.jmba.domain.BankProduct;
import ru.bsc.mbs.jmba.protocol.back.ProtocolObject;
import ru.bsc.mbs.jmba.protocol.view.BankProductShortView;

import java.util.Map;

/**
 * @author R. Malyshev
 */
public class JsonSerializer implements Processor {
  private static Logger log = LoggerFactory.getLogger(JsonSerializer.class);
  private ObjectWriter objectWriter;

  public JsonSerializer(Map<Class<?>, Class<?>> viewMapping) {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    for(Map.Entry<Class<?>, Class<?>> entry : viewMapping.entrySet()) {
      objectMapper.addMixInAnnotations(entry.getKey(), entry.getValue());
    }
    objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
  }

  @Override
  public void process(Exchange exchange) throws Exception {
    try {
      ProtocolObject o = exchange.getIn().getBody(ProtocolObject.class);
      String response = objectWriter.writeValueAsString(o);
      log.trace("Ready to send JSON response");
      exchange.getOut().setBody(response);
      exchange.getOut().setHeader("Content-Length", "" + response.length());
    } catch (JsonProcessingException e) {
      log.error("Can't serialize response", e);
      throw new RuntimeException(e);
    }
  }
}