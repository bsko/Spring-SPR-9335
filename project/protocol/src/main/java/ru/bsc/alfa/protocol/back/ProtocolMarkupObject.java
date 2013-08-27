package ru.bsc.alfa.protocol.back;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.markup.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Объект, сериализуемый JMBP с информацией о разметке. От данного класса должны наследоваться классы, описывающие ответы клиенту
 * @author Yuri Khrustalyov
 * 29.03.12
 */

abstract public class ProtocolMarkupObject<H extends Serializable> extends ProtocolObject {

  @Since(1.0) protected List<Field> fields;
  @Since(1.0) protected H header;

  final public List<Field> getFields() {
    return fields;
  }

  final public void setFields(List<Field> fields) {
    this.fields = fields;
  }

  final public H getHeader() {
    return header;
  }

  final public void setHeader(H header) {
    this.header = header;
  }

  final public void addField(Field field) {
    if(fields == null) {
      fields = new ArrayList<Field>();
    }
    fields.add(field);
  }

}
