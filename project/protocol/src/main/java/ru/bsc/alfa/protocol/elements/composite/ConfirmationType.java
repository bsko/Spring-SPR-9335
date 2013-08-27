package ru.bsc.alfa.protocol.elements.composite;

/**
 * @author rmalyshev
 *         date: 04.12.12
 */
public enum ConfirmationType {
  AUTH_TYPE_SMS("SMS"),
  AUTH_TYPE_NONE("NONE");

  private String type;

  private ConfirmationType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type;
  }
}
