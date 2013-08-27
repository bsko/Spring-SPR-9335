package ru.bsc.mbs.jmba.service.bank.products;

import ru.bsc.mbs.jmba.protocol.back.ProtocolObject;

/**
 * @author R. Malyshev
 */
public interface BankProductsService {
  
  ProtocolObject getBankProductsWithParam(ProtocolObject request);
  
  ProtocolObject getBankProducts();
}
