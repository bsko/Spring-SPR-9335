package ru.bsc.alfa.protocol.elements.requests.goals;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * author: esedyshev
 */
@OperationId("CustomerGoals:DeleteGoalConfirmation")
public class DeleteCustomerGoalConfirmationRequest extends ProtocolObject
{
  @Since(1.0)
  private String transactionReference;

  public String getTransactionReference() {
    return transactionReference;
  }

  public void setTransactionReference(String transactionReference) {
    this.transactionReference = transactionReference;
  }
}
