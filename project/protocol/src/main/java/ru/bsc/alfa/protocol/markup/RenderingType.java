package ru.bsc.alfa.protocol.markup;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Yuri Khrustalyov
 * 28.03.12
 */

/**
 * Enum для способов отрисовки поля на форме в клиенте:
 * <li>Amount</li>
 * <li>Label</li>
 * <li>Date</li>
 * <li>Phone1</li>
 * <li>Month1</li>
 * <li>Combobox</li>
 * <li>Field</li>
 * <li>Account</li>
 * <li>Clname</li>
 * <li>Checkbox</li>
 * <li>Attention</li>
 */
public enum RenderingType implements Serializable {
  Amount("amount"),
  Label("label"),
  Date("date"),
  Phone1("phone1"),
  Month1("month1"),
  Combobox("combobox"),
  Field("field"),
  Account("account"),
  Clname("clname"),
  Checkbox("checkbox"),
  Attention("attention"),
  Select("select");

  private String value;

  private RenderingType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  private static final HashMap<String, RenderingType> ENUM_MAP = new HashMap<String, RenderingType>();
  static {
    for(RenderingType t:values()) {
      ENUM_MAP.put(t.getValue(), t);
    }
  }

  public static RenderingType getRenderingType(String s) {
    RenderingType res = null;

    if(s != null) {
      res = ENUM_MAP.get(s.toLowerCase());
    }

    return res;
  }
}
