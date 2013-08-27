package ru.bsc.alfa.protocol.validation.validator;

//import ru.bsc.alfa.config.settings.SettingsContainer;
//import ru.bsc.alfa.config.settings.SettingsManager;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Map;

/**
 * @author R. Malyshev
 */
public class MandatoryParametersValidator implements ConstraintValidator<MandatoryParameters, Map<String, String>> {
  private String[] parms;
  private String msgParam;

  @Override
  public void initialize(MandatoryParameters parameters) {
    parms = parameters.parms();
    msgParam = parameters.message();
  }

  @Override
  public boolean isValid(Map<String, String> stringStringMap, ConstraintValidatorContext context) {
    boolean res = true;
    context.disableDefaultConstraintViolation();
    //SettingsContainer setts = SettingsManager.getSettings();
    //String message = setts.getProperty(msgParam);
    for(String parm : Arrays.asList(parms)){
      String v = stringStringMap.get(parm);
      if(v == null || v.isEmpty()) {
        context.buildConstraintViolationWithTemplate(msgParam).addNode(parm).addConstraintViolation();
        res = false;
      }
    }
    return res;
  }
}
