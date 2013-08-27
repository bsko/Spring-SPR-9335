package ru.bsc.alfa.protocol.elements.requests.cards.limits;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

import java.util.HashMap;

/**
 * @author R. Malyshev
 */
@OperationId("CustomerCardLimits:CreateLimitInitialStep")
public class CreateLimitInitialStepRequest extends ProtocolObject {
  private static final long serialVersionUID = 1787193688281342909L;

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
