package ru.bsc.alfa.protocol.elements.responses.goals;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

import java.io.Serializable;

/**
 * author: ykhrustalev
 * date: 17.04.12
 */
@OperationId("CustomerGoals:ReplenishRegisterTransferResult")
public class ReplenishRegisterTransferResponse extends ProtocolMarkupObject<ReplenishRegisterTransferResponse.Header> {

  {
    setHeader(new Header());
  }

  public static class Header implements Serializable {

    @Since(1.0) private Boolean registered;
    @Since(1.0) private String reference;

    public Boolean getRegistered() {
      return registered;
    }

    public void setRegistered(Boolean registered) {
      this.registered = registered;
    }

    public String getReference() {
      return reference;
    }

    public void setReference(String reference) {
      this.reference = reference;
    }

  }

  public void setRegistered(Boolean registered) {
    header.setRegistered(registered);
  }

  public void setReference(String reference) {
    header.setReference(reference);
  }
}
