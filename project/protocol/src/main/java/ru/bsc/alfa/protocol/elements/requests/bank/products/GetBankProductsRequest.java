package ru.bsc.alfa.protocol.elements.requests.bank.products;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * @author R. Malyshev
 */
@OperationId("BankProducts:GetBankProducts")
public class GetBankProductsRequest extends ProtocolObject {
  private static final long serialVersionUID = -5083226487883667504L;
}
