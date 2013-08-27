package ru.bsc.alfa.protocol.elements.requests.bump;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * Yuri Khrustalyov
 * 27.03.12
 */

@OperationId(value = "BumpTransfer:GetAccountList.Debit")
public class GetAccountListDebitRequest extends ProtocolObject {
  public GetAccountListDebitRequest() {
  }
}
