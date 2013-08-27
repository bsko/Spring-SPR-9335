package ru.bsc.alfa.protocol.back;

import com.google.gson.annotations.Since;

import java.io.Serializable;

/**
 * Это наиболее общий объект, сериализуемый протоколом JMBP. Любой
 * класс, унаследованный от данного класса, должен иметь аннотацию {@link OperationId}
 * с указанием уникального идентификатора операции.
 * <br />
 * Классы, описывающие запросы от клиентского приложения (т.е. Request-ы), должны быть непосредственно унаследованы от {@link ProtocolObject},
 * а классы, описывающие ответы клиенту (т.е. Response-ы), должны наследоваться от {@link ProtocolMarkupObject}, так как эти классы
 * должны содержать в себе информацию о разметке, тогда как классы для запросов никакой информации о разметке содержать не должны.
 *
 * @author Yuri Khrustalyov
 * 27.03.12
 */
public class ProtocolObject implements Serializable {

  @Since(1.0) private String operationId = null;


  public ProtocolObject() {
    OperationId tag = this.getClass().getAnnotation(OperationId.class);
    operationId = tag == null ? null : tag.value();
  }

  final public String getOperationId() {
    return operationId;
  }

  final public void setOperationId(String operationId) {
    this.operationId = operationId;
  }

}
