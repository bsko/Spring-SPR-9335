package ru.bsc.alfa.protocol.validation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import ru.bsc.alfa.jmb.base.exception.ErrorCode;
//import ru.bsc.alfa.jmb.base.exception.JMBException;
//import ru.bsc.alfa.jmb.base.exception.JMBProtocolValidationException;
import ru.bsc.alfa.protocol.back.ProtocolObject;
import ru.bsc.alfa.protocol.markup.Field;
import ru.bsc.alfa.protocol.validation.ValidationService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author R. Malyshev
 */
public class ValidationServiceImpl implements ValidationService {
  private static final Logger log = LoggerFactory.getLogger(ValidationServiceImpl.class);

  private Validator validator;

  @Override
  public void validate(ProtocolObject protocolObject){
//    Set<ConstraintViolation<ProtocolObject>> constraintViolations = validator.validate(protocolObject);
//    if(!constraintViolations.isEmpty()){
//      List<JMBProtocolValidationException.ValidationError> errors = new ArrayList<JMBProtocolValidationException.ValidationError>();
//      for(ConstraintViolation cv : constraintViolations){
//        log.error(
//            String.format("%s : %s", cv.getPropertyPath(), "missing field"/*cv.getMessage()*/)
//        );
//        errors.add(
//            new JMBProtocolValidationException.ValidationError(cv.getPropertyPath().toString(), cv.getMessage())
//        );
//      }
//      throw new JMBProtocolValidationException(errors, "Malformed JMBP request");
//    }
  }

  public void setValidator(Validator validator) {
    this.validator = validator;
  }
}
