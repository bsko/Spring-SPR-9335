package ru.bsc.mbs.jmba.protocol.back;

/**
 * @author R. Malyshev
 */
public class ProtocolMarkupObject<H> implements ProtocolObject {
  private H header;

  public H getHeader() {
    return header;
  }

  public void setHeader(H header) {
    this.header = header;
  }
}
