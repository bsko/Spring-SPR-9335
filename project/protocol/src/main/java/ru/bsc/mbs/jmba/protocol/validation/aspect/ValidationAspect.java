package ru.bsc.mbs.jmba.protocol.validation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author R. Malyshev
 */
@Aspect
public class ValidationAspect {

  @Before(value = "within(ru.bsc.mbs.jmba.service..*) && target(ru.bsc.mbs.jmba.protocol.validation.Validatable)")
  public void validate(JoinPoint point){
    System.out.println("validate...");
  }
}
