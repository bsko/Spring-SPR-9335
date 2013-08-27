package ru.bsc.alfa.protocol.elements.requests.online.registration;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;
import ru.bsc.alfa.protocol.validation.validator.MandatoryParameters;

import java.util.HashMap;

/**
 * @author R. Malyshev
 */
@OperationId("OnlineRegistration:Register")
public class RegisterRequest extends ProtocolObject {
  private static final long serialVersionUID = 3299793466404527110L;

  @MandatoryParameters(parms = {"#LITE", "#CRDN", "#VLDT", "#PHCL", "#MBPL"})
  @Since(1.0)
  private HashMap<String, String> parameters;

  public HashMap<String, String> getParameters() {
    return parameters;
  }

  public String getParameter(String parameter) {
    return parameters.get(parameter);
  }

  public void setParameters(HashMap<String, String> parameters) {
    this.parameters = parameters;
  }
}