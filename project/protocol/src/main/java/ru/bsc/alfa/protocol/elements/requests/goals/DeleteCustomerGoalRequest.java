package ru.bsc.alfa.protocol.elements.requests.goals;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.JMBPOptional;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * author: esedyshev
 */
@OperationId("CustomerGoals:DeleteGoal")
public class DeleteCustomerGoalRequest extends ProtocolObject
{
  @Since(1.0)
  private String goalId;
  @Since(1.0) @JMBPOptional
  private String accountNumber;

  public String getGoalId() {
    return goalId;
  }

  public void setGoalId(String goalId) {
    this.goalId = goalId;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }
}
