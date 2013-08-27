package ru.bsc.mbs.jmba.service.bank.products;

import ru.bsc.mbs.jmba.protocol.back.ProtocolMarkupObject;

/**
 * @author R. Malyshev
 */
public interface BankProductsService {
  ProtocolMarkupObject getBankProductsWithParam(BankProductsRequest request);

  ProtocolMarkupObject getBankProducts();
}
