package ru.bsc.alfa.protocol.elements.requests.cards;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

import java.util.Map;

/**
 * author: esedyshev
 */
@OperationId("CustomerCards:CardRemapRegister")
public class CardRemapRegisterRequest extends ProtocolObject
{
  private static final long serialVersionUID = -8117031904714479436L;

  @Since(1.0)
  private Map<String, String> parameters;

  public Map<String, String> getParameters() {
    return parameters;
  }

  public void setParameters(Map<String, String> parameters) {
    this.parameters = parameters;
  }
}
