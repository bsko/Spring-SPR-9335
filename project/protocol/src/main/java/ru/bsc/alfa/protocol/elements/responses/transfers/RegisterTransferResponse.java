package ru.bsc.alfa.protocol.elements.responses.transfers;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;
import ru.bsc.alfa.protocol.elements.composite.ConfirmationType;
import ru.bsc.alfa.protocol.elements.responses.TransferConfirmationResponse;

import java.io.Serializable;

/**
 * author: esedyshev
 */
@OperationId("Transfer:Registered")
public class RegisterTransferResponse extends ProtocolMarkupObject<RegisterTransferResponse.Header> implements TransferConfirmationResponse{
  private static final long serialVersionUID = 7640313264591299248L;

  public static class Header implements Serializable
  {
    private static final long serialVersionUID = 537692276237666610L;

    @Since(1.0) private String reference;
    @Since(1.0) private boolean registered;
    @Since(1.0) private String confirmationType;
    @Since(1.0) private Integer passwordLength;

    private Header() {
    }

    public String getReference() {
      return reference;
    }

    public void setReference(String reference) {
      this.reference = reference;
    }

    public boolean isRegistered() {
      return registered;
    }

    public void setRegistered(boolean registered) {
      this.registered = registered;
    }

    public String getConfirmationType() {
      return confirmationType;
    }

    public void setConfirmationType(String confirmationType) {
      this.confirmationType = confirmationType;
    }

    public Integer getPasswordLength() {
      return passwordLength;
    }

    public void setPasswordLength(Integer passwordLength) {
      this.passwordLength = passwordLength;
    }
  }

  private Header getNotNullHeader() {
    if(header == null) {
      header = new Header();
    }

    return header;
  }

  public void setReference(String reference) {
    getNotNullHeader().setReference(reference);
  }

  public void setRegistered(boolean registered) {
    getNotNullHeader().setRegistered(registered);
  }

  public void setConfirmationType(ConfirmationType type) {
    getNotNullHeader().setConfirmationType(type.toString());
  }

  public void setPasswordLength(Integer maxLen) {
    getNotNullHeader().setPasswordLength(maxLen);
  }

}