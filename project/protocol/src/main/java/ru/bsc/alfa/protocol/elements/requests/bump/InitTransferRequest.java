package ru.bsc.alfa.protocol.elements.requests.bump;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;
import ru.bsc.alfa.protocol.elements.composite.NameValuePair;

import java.util.ArrayList;

/**
 * Yuri Khrustalyov
 * 29.03.12
 */

@OperationId("BumpTransfer:InitTransfer")
public class InitTransferRequest extends ProtocolObject {
  @Since(1.0) private String creditId;
  @Since(1.0) private ArrayList<NameValuePair> fieldValues;

  public InitTransferRequest() {
  }

  public String getCreditId() {
    return creditId;
  }

  public void setCreditId(String creditId) {
    this.creditId = creditId;
  }

  public ArrayList<NameValuePair> getFieldValues() {
    return fieldValues;
  }

  public void setFieldValues(ArrayList<NameValuePair> fieldValues) {
    this.fieldValues = fieldValues;
  }
}
