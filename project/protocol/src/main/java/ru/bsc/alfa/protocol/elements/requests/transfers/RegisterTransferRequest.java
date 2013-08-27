package ru.bsc.alfa.protocol.elements.requests.transfers;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

import java.util.Map;

/**
 * author: esedyshev
 */
@OperationId("Transfer:Register")
public class RegisterTransferRequest  extends ProtocolObject {
  private static final long serialVersionUID = 4435990928038015750L;

  @Since(1.0)
  private Map<String, String> parameters;

  public Map<String, String> getParameters() {
    return parameters;
  }

  public void setParameters(Map<String, String> parameters) {
    this.parameters = parameters;
  }
}
