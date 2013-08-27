package ru.bsc.alfa.protocol.elements.composite;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.JMBPOptional;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Catalog element
 * @author rmalyshev
 *         date: 31.10.12
 */
public class CatalogElement implements Serializable {

  private static final long serialVersionUID = -1843647979955373050L;

  /**
   * Catalog element id
   */
  @Since(1.0) private String id;

  /**
   * Catalog element description
   */
  @Since(1.0) private String text;

  /**
   * Info
   */
  @Since(1.0) @JMBPOptional private HashMap<String, String> value;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = trim(text);
  }

  public HashMap<String, String> getValue() {
    return value;
  }

  public void setValue(HashMap<String, String> value) {
    this.value = value;
  }

  private String trim(String s) {
    return s != null ? s.trim() : null;
  }
}
