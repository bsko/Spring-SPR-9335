package ru.bsc.alfa.protocol.validation.validator;

import ru.bsc.alfa.protocol.validation.validator.MandatoryParametersValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author R. Malyshev
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MandatoryParametersValidator.class)
public @interface MandatoryParameters {
  String message() default "common.message.logicError.incorrectFieldsValue";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String[] parms() default {};
}
