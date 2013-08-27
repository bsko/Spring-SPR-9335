package ru.bsc.alfa.protocol.validation.service;

//import ru.bsc.alfa.config.settings.SettingsManager;

import javax.validation.MessageInterpolator;
import java.util.Locale;

/**
 * @author R. Malyshev
 */
public class JmbaSimpleMessageInterpolator implements MessageInterpolator {
  @Override
  public String interpolate(String messageTemplate, Context context) {
    return messageTemplate;
  }

  @Override
  public String interpolate(String messageTemplate, Context context, Locale locale) {
    return interpolate(messageTemplate, context);
  }
}
