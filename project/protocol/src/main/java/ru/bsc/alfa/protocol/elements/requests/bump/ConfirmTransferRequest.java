package ru.bsc.alfa.protocol.elements.requests.bump;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * Yuri Khrustalyov
 * 29.03.12
 */

@OperationId("BumpTransfer:Confirm")
public class ConfirmTransferRequest extends ProtocolObject {

  @Since(1.0) private boolean confirmed;
  @Since(1.0) private String paymentReference;

  public ConfirmTransferRequest() {
  }

  public boolean isConfirmed() {
    return confirmed;
  }

  public void setConfirmed(boolean confirmed) {
    this.confirmed = confirmed;
  }

  public String getPaymentReference() {
    return paymentReference;
  }

  public void setPaymentReference(String paymentReference) {
    this.paymentReference = paymentReference;
  }
}
