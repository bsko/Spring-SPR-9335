package ru.bsc.alfa.protocol.transformer;

import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Assert;
import org.junit.Test;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;
import ru.bsc.alfa.protocol.back.ProtocolObject;
import ru.bsc.alfa.protocol.elements.composite.Goal;
import ru.bsc.alfa.protocol.elements.responses.goals.CreateCustomerGoalInitialStepResponse;

import org.apache.camel.Exchange;
import ru.bsc.alfa.protocol.markup.Field;
import ru.bsc.alfa.protocol.markup.Type;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class ResponsePublisherTest extends CamelTestSupport {

  private Exchange exchange;
  private ResponsePublisher responsePublisher;
  private JMBPSerializer jmbpSerializer;

  public void init(){

    responsePublisher = new ResponsePublisher();

    jmbpSerializer = new JMBPSerializer();
    jmbpSerializer.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    jmbpSerializer.setVersion(new Double("1.0"));
    jmbpSerializer.init();
    responsePublisher.setJmbpSerializer(jmbpSerializer);

  }

    @Test
    public void testSuccessfulSerializeResponse(){
      init();

      CreateCustomerGoalInitialStepResponse response = new CreateCustomerGoalInitialStepResponse();

      Field charField = new Field();
      charField.setName("Test field");
      charField.setValue("test value");
      charField.setHint("This is test char field");
      charField.setDescription("Test description");
      charField.setType(Type.Char);
      response.addField(charField);

      Field dateField = new Field();
      dateField.setName("Test field");
      dateField.setValue("2012-03-22T00:00:00.000+0400");
      dateField.setHint("This is test date field");
      dateField.setDescription("Test description");
      dateField.setType(Type.Date);
      response.addField(dateField);

      Field listField = new Field();
      listField.setName("Test field");
      ArrayList<Goal> goals = new ArrayList<Goal>();
      goals.add(new Goal().setName("Test goal 1").setAccountNumber("1234567890"));
      goals.add(new Goal().setName("Test goal 2").setAccountNumber("9876543210"));
      listField.setValue(goals);
      listField.setHint("This is test list field");
      listField.setDescription("Test description");
      listField.setType(Type.List);
      response.addField(listField);

      Field zonedField = new Field();
      zonedField.setName("Test field");
      zonedField.setValue("1 123.00");
      zonedField.setHint("This is test zoned field");
      zonedField.setDescription("Test description");
      zonedField.setType(Type.Zoned);
      response.addField(zonedField);

      exchange = createExchangeWithBody(response);
      
      responsePublisher.serializeResponse(exchange);

      String jsonString = new StringBuilder()
      .append("{\n  \"fields\": [")
      .append("\n    {")
      .append("\n      \"name\": \"Test field\",")
      .append("\n      \"description\": \"Test description\",")
      .append("\n      \"hint\": \"This is test char field\",")
      .append("\n      \"type\": \"Char\",")
      .append("\n      \"value\": \"test value\"")
      .append("\n    },")
      .append("\n    {")
      .append("\n      \"name\": \"Test field\",")
      .append("\n      \"description\": \"Test description\",")
      .append("\n      \"hint\": \"This is test date field\",")
      .append("\n      \"type\": \"Date\",")
      .append("\n      \"value\": \"2012-03-22T00:00:00.000+0400\"")
      .append("\n    },")
      .append("\n    {")
      .append("\n      \"name\": \"Test field\",")
      .append("\n      \"description\": \"Test description\",")
      .append("\n      \"hint\": \"This is test list field\",")
      .append("\n      \"type\": \"List\",")
      .append("\n      \"value\": [")
      .append("\n        {")
      .append("\n          \"name\": \"Test goal 1\",")
      .append("\n          \"accountNumber\": \"1234567890\"")
      .append("\n        },")
      .append("\n        {")
      .append("\n          \"name\": \"Test goal 2\",")
      .append("\n          \"accountNumber\": \"9876543210\"")
      .append("\n        }")
      .append("\n      ]")
      .append("\n    },")
      .append("\n    {")
      .append("\n      \"name\": \"Test field\",")
      .append("\n      \"description\": \"Test description\",")
      .append("\n      \"hint\": \"This is test zoned field\",")
      .append("\n      \"type\": \"Zoned\",")
      .append("\n      \"value\": \"1 123.00\"")
      .append("\n    }")
      .append("\n  ],")
      .append("\n  \"operationId\": \"CustomerGoals:CreateGoalInitialStepResult\"")
      .append("\n}")
      .toString();

      Assert.assertEquals(jsonString, exchange.getOut().getBody());
      Assert.assertEquals("976", exchange.getOut().getHeader("Content-Length"));

    }

    @Test
    public void testUnsuccessfulSerializeResponse(){
      init();

      try{
        exchange = createExchangeWithBody(null);
        responsePublisher.serializeResponse(exchange);
        Assert.fail("There should be an exception!");
      } catch (NullPointerException e){

      }

      try{
        exchange = createExchangeWithBody("abc");
        responsePublisher.serializeResponse(exchange);
        Assert.fail("There should be an exception!");
      } catch (Exception e){

      }

      try{
        exchange = createExchangeWithBody(new ProtocolObject());
        responsePublisher.serializeResponse(exchange);
        Assert.fail("There should be an exception!");
      } catch (Exception e){

      }

    }

    @Test
    public void testSuccessfulPublishResponse(){

      init();

      exchange = createExchangeWithBody("abc");
      
      responsePublisher.publishResponse(exchange);

      Assert.assertEquals("abc", ((ByteArrayOutputStream) exchange.getOut().getBody()).toString());
      Assert.assertEquals(new Double("1.0"), exchange.getOut().getHeader(ResponsePublisher.JMBP_VERSION));
    }

    @Test
    public void testUnsuccessfulPublishResponse(){

      init();

      try{
        exchange = createExchangeWithBody(null);
        responsePublisher.publishResponse(exchange);
        Assert.fail("There should be an exception!");
      } catch (NullPointerException e){

      }
    }
}
