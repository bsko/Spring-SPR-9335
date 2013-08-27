package ru.bsc.alfa.protocol.transformer;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Since;
//import ru.bsc.alfa.jmb.base.exception.JMBException;
import ru.bsc.alfa.protocol.back.JMBPExclusionStrategy;
import ru.bsc.alfa.protocol.back.JMBPIgnore;
import ru.bsc.alfa.protocol.back.JMBPOptional;
import ru.bsc.alfa.protocol.transformer.adapter.IntegerTypeAdapter;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Yuri Khrustalyov
 * 29.03.12
 */

public class JMBPSerializer {

  private Double version;
  private String dateFormat;
  private Gson gson;

  public void init() {
    gson = createGson(version);
  }

  private Gson createGson(double actualVersion) {

    ExclusionStrategy strategy = new JMBPExclusionStrategy();

    return new GsonBuilder()
      .setVersion(actualVersion)
      .setDateFormat(dateFormat)
      .setPrettyPrinting()
      .addDeserializationExclusionStrategy(strategy)
      .addSerializationExclusionStrategy(strategy)
      .registerTypeAdapter(Integer.class, new IntegerTypeAdapter())
      .create();
  }

  public Double getVersion() {
    return version;
  }

  public void setVersion(Double version) {
    this.version = version;
  }

  public String getDateFormat() {
    return dateFormat;
  }

  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }
  
  public String serialize(Object object, Class clazz) {
    return gson.toJson(object, clazz);
  }

  public <T> T deSerialize(String jsonString, Class<T> clazz, double actualVersion) throws IllegalAccessException, IntrospectionException, InvocationTargetException {//throws JMBException

    T result;
    if(actualVersion != version) {
      result = createGson(actualVersion).fromJson(jsonString, clazz);
    } else {
      result = gson.fromJson(jsonString, clazz);
    }

    Map<Field, Method> fields = getProtocolRequiredFieldsAccessMethods(clazz);

    for(Map.Entry<Field, Method> entry : fields.entrySet()) {

      Field field = entry.getKey();
      Method getMethod = entry.getValue();

      Object value = getValue(result, getMethod);

      if(!checkField(field, value)) {
//        throw new JMBException("Required field '"  + field.getName() + "' is not set or can not be accessed");
      }

    }

    return result;
  }

  private <T> Object getValue(T object, Method getMethod) throws InvocationTargetException, IllegalAccessException {
    return getMethod.invoke(object);
  }

  private <T> boolean checkField(Field field, T fieldValueObject) throws IllegalAccessException, IntrospectionException, InvocationTargetException {

    if(field.isSynthetic() && fieldValueObject != null) {
      for(Map.Entry<Field, Method> entry : getProtocolRequiredFieldsAccessMethods(field.getClass()).entrySet()) {

        Field subField = entry.getKey();
        Method subGetMethod = entry.getValue();

        if(!checkField(subField, getValue(fieldValueObject, subGetMethod))) {
          return false;
        }
      }
    }

    boolean isCollection = Collection.class.isAssignableFrom(field.getType());
    boolean isCollectionEmpty = isCollection ? ( fieldValueObject != null && ((Collection)fieldValueObject).isEmpty() ) : false;

    boolean isMap = Map.class.isAssignableFrom(field.getType());
    boolean isMapEmpty = isMap ? ( fieldValueObject != null && ((Map)fieldValueObject).isEmpty() ) : false;

    return !(fieldValueObject == null || isCollectionEmpty || isMapEmpty );

  }

  private Map<Field, Method> getProtocolRequiredFieldsAccessMethods(Class<?> type) throws IntrospectionException {

    Map<Field, Method> fields = new HashMap<Field, Method>();

    for (Class<?> c = type; c != null; c = c.getSuperclass()) {

      Map<String, Field> fieldMap = new HashMap<String, Field>();

      for(Field field : c.getDeclaredFields()) {
        fieldMap.put(field.getName(), field);
      }

      for(PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(c).getPropertyDescriptors()) {

        Field field = fieldMap.get(propertyDescriptor.getName());
        if(field != null && field.isAnnotationPresent(Since.class) && !field.isAnnotationPresent(JMBPIgnore.class) && !field.isAnnotationPresent(JMBPOptional.class)) {

          fields.put(field, propertyDescriptor.getReadMethod());

        }

      }

    }
    return fields;
  }

}
