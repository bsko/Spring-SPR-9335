package ru.bsc.alfa.protocol.back;

/**
 * Уникальный идентификатор операции
 * @author Yuri Khrustalyov
 * 27.03.12
 */

@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE})
public @interface OperationId {
  String value();
}
