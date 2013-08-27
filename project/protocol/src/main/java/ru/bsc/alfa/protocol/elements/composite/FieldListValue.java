package ru.bsc.alfa.protocol.elements.composite;

import com.google.gson.annotations.Since;

import java.io.Serializable;

/**
 * author: esedyshev
 */
public class FieldListValue implements Serializable
{
  @Since(1.0) private String value;
  @Since(1.0) private String description;

  public FieldListValue() {
  }

  public FieldListValue(String value, String description) {
    this.value = value;
    this.description = description;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
