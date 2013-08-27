package ru.bsc.alfa.protocol.back;

/**
 * Помеченное поле необязательно
 * @author: ykhrustalev
 * date: 17.04.12
 */
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE})
public @interface JMBPOptional {
}
