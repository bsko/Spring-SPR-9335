package ru.bsc.alfa.protocol.elements.responses.bump;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

import java.io.Serializable;

/**
 * Yuri Khrustalyov
 * 29.03.12
 */

@OperationId("BumpTransfer:CreditId")
public class SetCreditAccountResponse extends ProtocolMarkupObject<SetCreditAccountResponse.Header> {

  public static class Header implements Serializable {
    @Since(1.0) private String creditId;

    public Header() {
    }

    public String getCreditId() {
      return creditId;
    }

    public Header setCreditId(String creditId) {
      this.creditId = creditId;
      return this;
    }
  }

  public SetCreditAccountResponse() {
  }
}
