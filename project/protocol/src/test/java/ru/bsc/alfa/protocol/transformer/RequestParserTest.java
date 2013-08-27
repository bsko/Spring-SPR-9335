package ru.bsc.alfa.protocol.transformer;

import org.apache.camel.test.junit4.CamelTestSupport;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

//import ru.bsc.alfa.jmb.base.exception.JMBException;
import ru.bsc.alfa.protocol.back.OperationMapping;
import ru.bsc.alfa.protocol.elements.requests.bump.InitTransferRequest;

import org.apache.camel.Exchange;

public class RequestParserTest extends CamelTestSupport {
   
  private Exchange exchange;
  private RequestParser requestParser;
  private OperationMapping operationMapping;
  private JMBPSerializer jmbpSerializer;

  public void init(){

    requestParser = new RequestParser();

    jmbpSerializer = new JMBPSerializer();
    jmbpSerializer.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    jmbpSerializer.setVersion(new Double("1.0"));
    jmbpSerializer.init();
    requestParser.setJmbpSerializer(jmbpSerializer);

    operationMapping = EasyMock.createMock(OperationMapping.class);
    EasyMock.expect(operationMapping.getType("BumpTransfer:InitTransfer")).andReturn((Class) InitTransferRequest.class);
    EasyMock.replay(operationMapping);

    requestParser.setOperationMapping(operationMapping);

  }

  @Test
  public void testSuccessfulParse() throws Exception{

    init();

    exchange = createExchangeWithBody(new StringBuilder()
    .append("{\n  \"operationId\":\"BumpTransfer:InitTransfer\",")
    .append("\n  \"creditId\":\"e018d955-25cb-472e-80ae-2554e69af107-52\",")
    .append("\n  \"fieldValues\":")
    .append("\n  [")
    .append("\n    {\"name\":\"#ACCD\",\"value\":\"40817810000000000233\"},")
    .append("\n    {\"name\":\"#SUMM\",\"value\":\"1 024.05\"},")
    .append("\n    {\"name\":\"#RDSC\",\"value\":\"На хорошую жизнь\"}")
    .append("\n  ]\n}")
    .toString());

    exchange.getIn().setHeader(ResponsePublisher.JMBP_VERSION, "1.0");
    exchange.getIn().setHeader(RequestParser.SERVICE_BUNDLE_NAME, "BumpTransfer");
    
    requestParser.parse(exchange);

    Assert.assertEquals("InitTransfer", exchange.getIn().getHeader("jmbCamelURI"));
    Assert.assertEquals("BumpTransfer:InitTransfer", exchange.getIn().getHeader("jmba_request_command"));

    InitTransferRequest request = (InitTransferRequest) exchange.getIn().getBody();
    Assert.assertEquals("BumpTransfer:InitTransfer", request.getOperationId());
    Assert.assertEquals("e018d955-25cb-472e-80ae-2554e69af107-52", request.getCreditId());

    Assert.assertEquals(3, request.getFieldValues().size());
    Assert.assertEquals("#ACCD", request.getFieldValues().get(0).getName());
    Assert.assertEquals("40817810000000000233", request.getFieldValues().get(0).getValue());
    Assert.assertEquals("#SUMM", request.getFieldValues().get(1).getName());
    Assert.assertEquals("1 024.05", request.getFieldValues().get(1).getValue());
    Assert.assertEquals("#RDSC", request.getFieldValues().get(2).getName());
    Assert.assertEquals("На хорошую жизнь", request.getFieldValues().get(2).getValue());
  }

  @Test
  public void testUnsuccessfulParse() throws Exception{

//    init();
//
//    try {
//      exchange = createExchangeWithBody("abc");
//      exchange.getIn().setHeader(ResponsePublisher.JMBP_VERSION, "1.0");
//      exchange.getIn().setHeader(RequestParser.SERVICE_BUNDLE_NAME, "CustomerGoals");
//      requestParser.parse(exchange);
//      Assert.fail("There should be an exception!");
//    } catch (Exception e) {//JMBException e) {
//        
//    }
//
//    try {
//      exchange = createExchangeWithBody("{\"operationId\":\"CustomerGoals:CreateGoalInitialStep\"}");
//      exchange.getIn().setHeader(ResponsePublisher.JMBP_VERSION, "0.0");
//      exchange.getIn().setHeader(RequestParser.SERVICE_BUNDLE_NAME, "CustomerGoals");
//      requestParser.parse(exchange);
//      Assert.fail("There should be an exception!");
//    } catch (Exception e){ //JMBException e) {
//
//    }
//
//    try {
//      exchange = null;
//      requestParser.parse(exchange);
//      Assert.fail("There should be an exception!");
//    } catch (NullPointerException e) {
//
//    }

  }

}
