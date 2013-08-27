package ru.bsc.alfa.protocol.elements.requests.goals;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;

/**
 * author: ykhrustalev
 * date: 17.04.12
 */
@OperationId("CustomerGoals:ReplenishConfirm")
public class ReplenishConfirmRequest extends ViewCustomerGoalRequest {

  @Since(1.0) private Boolean confirmed;
  @Since(1.0) private String reference;

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Boolean getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(Boolean confirmed) {
    this.confirmed = confirmed;
  }
}
