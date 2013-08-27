package ru.bsc.alfa.protocol.elements.responses.lite;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

import java.io.Serializable;

/**
 * author: esedyshev
 */
@OperationId("MobileLite:ShiftToFullVersionResult")
public class ShiftToFullVersionResponse extends ProtocolMarkupObject<ShiftToFullVersionResponse.Header>
{
  public static class Header implements Serializable
  {
    @Since(1.0) private boolean registered;

    private Header() {
    }

    public boolean isRegistered() {
      return registered;
    }

    public void setRegistered(boolean registered) {
      this.registered = registered;
    }
  }

  public ShiftToFullVersionResponse() {
  }

  public void setRegistered(boolean registered) {
    if(header==null) {
      header = new Header();
    }

    header.setRegistered(registered);
  }
}
