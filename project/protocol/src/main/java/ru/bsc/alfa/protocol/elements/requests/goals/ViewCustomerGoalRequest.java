package ru.bsc.alfa.protocol.elements.requests.goals;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * author: ykhrustalev
 * date: 17.04.12
 */
@OperationId("CustomerGoals:ViewGoal")
public class ViewCustomerGoalRequest extends ProtocolObject {
  @Since(1.0) private String goalId;

  public String getGoalId() {
    return goalId;
  }

  public void setGoalId(String goalId) {
    this.goalId = goalId;
  }
}
