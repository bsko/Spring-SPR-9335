package ru.bsc.alfa.protocol.transformer;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Yuri Khrustalyov
 * 29.03.12
 */

public class ResponsePublisher {

  final private static Logger logger = LoggerFactory.getLogger(ResponsePublisher.class);

  final public static String JMBP_VERSION = "jmb-protocol-version";
  
  private JMBPSerializer jmbpSerializer;

  /**
   * Этот метод достает из параметра exchange объект, класс которого
   * унаследован от {@link ProtocolMarkupObject}, сериализует его в JSON
   * и полученную JSON-строку кладет в exchange для последующей
   * отправки на клиент
   * @param exchange стандартный объект обмена данными между сервис-бинами в Camel.
   */
  public void serializeResponse(Exchange exchange) {
    ProtocolMarkupObject resultData = exchange.getIn().getBody(ProtocolMarkupObject.class);
    String jsonString = jmbpSerializer.serialize(resultData, resultData.getClass());
    logger.trace("Ready to send JSON response: " + jsonString);
    exchange.getOut().setBody(jsonString);
    exchange.getOut().setHeader("Content-Length", "" + jsonString.length());
  }


  /**
   * Формирует полный ответ клиенту, отправляет ответ в виде массива байт
   * @param exchange Apache Camel {@link Exchange} - содержит результат обработки клиентского запроса
   */
  public void publishResponse(Exchange exchange) {

    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream resultStream = new DataOutputStream(byteArrayOutputStream);

      byte[] resultData = exchange.getIn().getBody(byte[].class);

      resultStream.write(resultData);

      exchange.getOut().setBody(byteArrayOutputStream);

      exchange.getOut().setHeader(JMBP_VERSION, jmbpSerializer.getVersion());

    } catch (IOException e) {
      logger.error("Can't write response code", e);
    }
  }

  public JMBPSerializer getJmbpSerializer() {
    return jmbpSerializer;
  }

  public void setJmbpSerializer(JMBPSerializer jmbpSerializer) {
    this.jmbpSerializer = jmbpSerializer;
  }
}
