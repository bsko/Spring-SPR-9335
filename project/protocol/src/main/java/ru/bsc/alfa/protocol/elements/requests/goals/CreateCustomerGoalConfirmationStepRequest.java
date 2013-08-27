package ru.bsc.alfa.protocol.elements.requests.goals;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;
import ru.bsc.alfa.protocol.elements.composite.NameValuePair;

import java.util.ArrayList;

/**
 * author: esedyshev
 */
@OperationId("CustomerGoals:CreateGoalConfirmationStep")
public class CreateCustomerGoalConfirmationStepRequest extends ProtocolObject {
  @Since(1.0) private ArrayList<NameValuePair> fieldValues;

  public ArrayList<NameValuePair> getFieldValues() {
    return fieldValues;
  }

  public void setFieldValues(ArrayList<NameValuePair> fieldValues) {
    this.fieldValues = fieldValues;
  }
}
