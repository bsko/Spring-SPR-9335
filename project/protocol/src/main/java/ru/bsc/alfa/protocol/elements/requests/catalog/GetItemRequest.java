package ru.bsc.alfa.protocol.elements.requests.catalog;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.JMBPOptional;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

import java.util.HashMap;

/**
 * @author rmalyshev
 *         date: 31.10.12
 */
@OperationId("Catalog:GetItem")
public class GetItemRequest extends ProtocolObject{
  @Since(1.0) private HashMap<String, String> parameters;

  public HashMap<String, String> getParameters() {
    return parameters;
  }

  public void setParameters(HashMap<String, String> parameters) {
    this.parameters = parameters;
  }
}
