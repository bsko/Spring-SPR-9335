package ru.bsc.alfa.protocol.markup;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Yuri Khrustalyov
 * 28.03.12
 */

/**
 * Enum для типов полей:
 * <li>Char</li>
 * <li>Zoned</li>
 * <li>Date</li>
 * <li>List</li>
 * <li>TimeStamp</li>
 */
public enum Type implements Serializable {
  Char("char"),
  Zoned("zoned"),
  Date("date"),
  List("list"),
  TimeStamp("timestamp");

  private String value;

  private Type(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  private static final HashMap<String, Type> ENUM_MAP = new HashMap<String, Type>();
  static {
    for(Type t:values()) {
      ENUM_MAP.put(t.getValue(), t);
    }
  }

  public static Type getType(String s) {
    Type res = null;

    if(s != null) {
      res = ENUM_MAP.get(s.toLowerCase());
    }

    return res == null ? Char : res;
  }
}
