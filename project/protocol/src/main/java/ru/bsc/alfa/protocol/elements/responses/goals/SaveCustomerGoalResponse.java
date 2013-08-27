package ru.bsc.alfa.protocol.elements.responses.goals;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

import java.io.Serializable;

/**
 * author: ykhrustalev
 * date: 17.04.12
 */
@OperationId("CustomerGoals:SaveGoalResult")
public class SaveCustomerGoalResponse extends ProtocolMarkupObject<SaveCustomerGoalResponse.Header> {
  public static class Header implements Serializable
  {
    @Since(1.0) private boolean registered;

    public boolean isRegistered() {
      return registered;
    }

    public void setRegistered(boolean registered) {
      this.registered = registered;
    }
  }

  public void setRegistered(boolean registered) {
    if(header==null) {
      header = new Header();
    }

    header.setRegistered(registered);
  }

}
