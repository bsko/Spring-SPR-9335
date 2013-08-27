package ru.bsc.alfa.protocol.elements.responses.cards;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;
import ru.bsc.alfa.protocol.elements.composite.ConfirmationType;
import ru.bsc.alfa.protocol.elements.responses.TransferConfirmationResponse;

import java.io.Serializable;

/**
 * author: esedyshev
 */
@OperationId("CustomerCards:CardRemapRegistered")
public class CardRemapRegisterResponse extends ProtocolMarkupObject<CardRemapRegisterResponse.Header> implements TransferConfirmationResponse
{
  private static final long serialVersionUID = -4555763432938490007L;

  public static class Header implements Serializable
  {
    private static final long serialVersionUID = -7077900534466806456L;

    @Since(1.0) private boolean registered;
    @Since(1.0) private String reference;
    @Since(1.0) private String confirmationType;
    @Since(1.0) private Integer passwordLength;

    public boolean isRegistered() {
      return registered;
    }

    public void setRegistered(boolean registered) {
      this.registered = registered;
    }

    public String getReference() {
      return reference;
    }

    public void setReference(String reference) {
      this.reference = reference;
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

  public void setRegistered(boolean registered) {
    getNotNullHeader().registered = registered;
  }

  public void setReference(String reference) {
    getNotNullHeader().reference = reference;
  }

  public void setConfirmationType(ConfirmationType confirmationType) {
    getNotNullHeader().confirmationType = confirmationType.toString();
  }

  @Override
  public void setPasswordLength(Integer maxLen) {
    getNotNullHeader().setPasswordLength(maxLen);
  }
}
