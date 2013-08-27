package ru.bsc.alfa.protocol.elements.requests.transfers;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

import java.util.Map;

/**
 * author: esedyshev
 */
@OperationId("Transfer:GetFields")
public class GetFieldsRequest extends ProtocolObject {
  private static final long serialVersionUID = 5560932114594984764L;

  @Since(1.0)
  private Map<String, String> parameters;

  public Map<String, String> getParameters() {
    return parameters;
  }

  public void setParameters(Map<String, String> parameters) {
    this.parameters = parameters;
  }
}
