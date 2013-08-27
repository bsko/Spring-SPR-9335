package ru.bsc.mbs.jmba.protocol.back;

import ru.bsc.alfa.protocol.markup.Field;

import java.util.List;

/**
 * @author R. Malyshev
 */
public class ProtocolMarkupObject<H> implements ProtocolObject {
  private H header;
  private List<Field> fields;

  public H getHeader() {
    return header;
  }

  public void setHeader(H header) {
    this.header = header;
  }

  public List<Field> getFields() {
    return fields;
  }

  public void setFields(List<Field> fields) {
    this.fields = fields;
  }
}
