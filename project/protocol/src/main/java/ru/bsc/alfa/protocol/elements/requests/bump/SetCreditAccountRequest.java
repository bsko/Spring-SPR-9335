package ru.bsc.alfa.protocol.elements.requests.bump;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * Yuri Khrustalyov
 * 29.03.12
 */

@OperationId("BumpTransfer:SetAccount.Credit")
public class SetCreditAccountRequest extends ProtocolObject {

  @Since(1.0) private String accountNumber;

  public SetCreditAccountRequest() {
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }
}
