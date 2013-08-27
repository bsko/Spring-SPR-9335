package ru.bsc.alfa.protocol.elements.responses.bump;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

import java.io.Serializable;

/**
 * Yuri Khrustalyov
 * 29.03.12
 */

@OperationId("BumpTransfer:VerifyTransfer")
public class InitTransferResponse extends ProtocolMarkupObject<InitTransferResponse.Header> {

  public static class Header implements Serializable
  {
    @Since(1.0) private String paymentReference;
    @Since(1.0) private boolean registered;

    private Header() {
    }

    public String getPaymentReference() {
      return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
      this.paymentReference = paymentReference;
    }

    public boolean isRegistered() {
      return registered;
    }

    public void setRegistered(boolean registered) {
      this.registered = registered;
    }
  }
  
  public InitTransferResponse() {
  }
  
  public void setPaymentReference(String paymentReference) {
    if(header==null) {
      header = new Header();
    }

    header.setPaymentReference(paymentReference);
  }

  public void setRegistered(boolean registered) {
    if(header==null) {
      header = new Header();
    }

    header.setRegistered(registered);
  }
}
