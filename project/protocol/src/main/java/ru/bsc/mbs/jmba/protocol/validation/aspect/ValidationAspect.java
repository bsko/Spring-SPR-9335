package ru.bsc.mbs.jmba.protocol.validation.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import ru.bsc.alfa.protocol.validation.ValidationService;
import ru.bsc.alfa.protocol.validation.service.JmbaSimpleMessageInterpolator;
import ru.bsc.alfa.protocol.validation.service.ValidationServiceImpl;
import ru.bsc.mbs.jmba.protocol.back.ProtocolObject;
import ru.bsc.mbs.jmba.protocol.validation.Validatable;

/**
 * @author R. Malyshev
 */
@Aspect
public class ValidationAspect {
  private static Logger log = LoggerFactory.getLogger(ValidationAspect.class);

  private ValidationService validationService;
  {
    ValidationServiceImpl v = new ValidationServiceImpl();
    LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
    localValidatorFactoryBean.setMessageInterpolator(new JmbaSimpleMessageInterpolator());
    v.setValidator(localValidatorFactoryBean);
    validationService = v;
  }

/*  @Before(value = "execution(public * ru.bsc.mbs.jmba.service..*.*(..)) && target(validatable) && args(protocolObject)", argNames = "validatable,protocolObject")
  public void validate(Validatable validatable, ProtocolObject protocolObject){
    log.info("Validating...");
    //validationService.validate(protocolObject);
  }*/

  @Before(value = "within(ru.bsc.mbs.jmba.service..*) && target(ru.bsc.mbs.jmba.protocol.validation.Validatable) && args(protocolObject)", argNames = "protocolObject")
  public void validate(ProtocolObject protocolObject){
    log.info("Validating...");
    //validationService.validate(protocolObject);
  }
}
