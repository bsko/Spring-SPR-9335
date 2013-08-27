package ru.bsc.alfa.protocol.back;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Реализация стратегии пропуска полей и классов
 * @author ykhrustalev
 * date: 17.04.12
 */
public class JMBPExclusionStrategy implements ExclusionStrategy {

  @Override
  public boolean shouldSkipField(FieldAttributes f) {
    return f.getAnnotation(JMBPIgnore.class) != null && f.getAnnotation(JMBPIgnore.class).value();
  }

  @Override
  public boolean shouldSkipClass(Class<?> clazz) {
    return false;
  }
}
