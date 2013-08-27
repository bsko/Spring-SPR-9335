package ru.bsc.alfa.protocol.elements.responses.bump;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;


/**
 * Yuri Khrustalyov
 * 27.03.12
 */

@OperationId(value = "BumpTransfer:AccountList.Debit")
public class GetAccountListDebitResponse extends ProtocolMarkupObject {
  public GetAccountListDebitResponse() {
  }
}
