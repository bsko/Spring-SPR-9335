package ru.bsc.alfa.protocol.elements.requests.cards.limits;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

import java.util.HashMap;

/**
 * @author R. Malyshev
 */
@OperationId("CustomerCardLimits:GetLimitsList")
public class GetLimitsListRequest extends ProtocolObject {
  private static final long serialVersionUID = -7341639423676871481L;

  @Since(1.0) private HashMap<String, String> parameters;

  public HashMap<String, String> getParameters() {
    return parameters;
  }

  public void setParameters(HashMap<String, String> parameters) {
    this.parameters = parameters;
  }
}
