package ru.bsc.alfa.protocol.elements.composite;

import com.google.gson.annotations.Since;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author R. Malyshev
 */
public class NameValues implements Serializable {
  private static final long serialVersionUID = -5032762527343628518L;

  @Since(1.0)
  private String name;

  @Since(1.0)
  private String value;

  @Since(1.0)
  private ArrayList<String> values;

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }

  public List<String> getValues() {
    return values;
  }

  public void set(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public void set(String name, List<String> values) {
    this.name = name;
    this.values = new ArrayList<String>(values);
  }

  public static Map<String, String> makeValueMap(List<NameValues> nameValuesList){
    Map<String, String> valueMap = new HashMap<String, String>();

    for(NameValues nameValues: nameValuesList){
      if(nameValues.getValue() != null)
        valueMap.put(nameValues.getName(), nameValues.getValue());
    }
    return valueMap;
  }

  public static Map<String, List<String>> makeValuesMap(List<NameValues> nameValuesList){
    Map<String, List<String>> valueMap = new HashMap<String, List<String>>();

    for(NameValues nameValues: nameValuesList){
      if(nameValues.getValues() != null)
        valueMap.put(nameValues.getName(), nameValues.getValues());
    }
    return valueMap;
  }
}
