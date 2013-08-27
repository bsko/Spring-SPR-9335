package ru.bsc.alfa.protocol.elements.composite;

import com.google.gson.annotations.Since;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * author esedyshev
 */
public class NameValuePair implements Serializable
{
  @Since(1.0) private String name;
  @Since(1.0) private String value;

  public NameValuePair() {
  }

  public NameValuePair(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Метод делает мап-ку из списка пар имя=значения, с именами в качестве ключей.
   * @param list список для преобразования в мап-ку.
   * @return мап-ку из списка пар имя=значения, с именами в качестве ключей
   */
  public static Map<String, String> makeMap(List<NameValuePair> list) {
    Map<String, String> map = new LinkedHashMap<String, String>();

    for(NameValuePair pair : list) {
      map.put(pair.getName(), pair.getValue());
    }

    return map;
  }


}
