package ru.bsc.mbs.jmba.service.bank.products;

import ru.bsc.alfa.protocol.elements.requests.bank.products.GetBankProductsRequest;
import ru.bsc.alfa.protocol.elements.responses.bank.products.GetBankProductsResponse;
import ru.bsc.mbs.jmba.protocol.back.ProtocolMarkupObject;

/**
 * @author R. Malyshev
 */
public interface BankProductsService {
  ProtocolMarkupObject getBankProductsWithParam(BankProductsRequest request);

  ProtocolMarkupObject getBankProducts();
}
