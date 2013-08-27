package ru.bsc.alfa.protocol.elements.requests.goals;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.elements.composite.NameValuePair;

import java.util.ArrayList;

/**
 * author: ykhrustalev
 * date: 17.04.12
 */
@OperationId("CustomerGoals:ReplenishRegisterTransfer")
public class ReplenishRegisterTransferRequest extends ViewCustomerGoalRequest {

  @Since(1.0) private ArrayList<NameValuePair> fieldValues;

  public ArrayList<NameValuePair> getFieldValues() {
    return fieldValues;
  }

  public void setFieldValues(ArrayList<NameValuePair> fieldValues) {
    this.fieldValues = fieldValues;
  }

}
