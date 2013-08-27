package ru.bsc.alfa.protocol.elements.responses.goals;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

import java.io.Serializable;

/**
 * author: esedyshev
 */
@OperationId("CustomerGoals:CreateGoalConfirmationStepResult")
public class CreateCustomerGoalConfirmationStepResponse extends ProtocolMarkupObject<CreateCustomerGoalConfirmationStepResponse.Header>
{
  public static class Header implements Serializable
  {
    @Since(1.0) private String transactionReference;
    @Since(1.0) private boolean registered;

    public String getTransactionReference() {
      return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
      this.transactionReference = transactionReference;
    }

    public boolean isRegistered() {
      return registered;
    }

    public void setRegistered(boolean registered) {
      this.registered = registered;
    }
  }

  public void setTransactionReference(String transactionReference) {
    if(header==null) {
      header = new Header();
    }

    header.setTransactionReference(transactionReference);
  }

  public void setRegistered(boolean registered) {
    if(header==null) {
      header = new Header();
    }

    header.setRegistered(registered);
  }
}
