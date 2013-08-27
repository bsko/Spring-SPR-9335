package ru.bsc.mbs.jmba.service.bank.products;

import ru.bsc.mbs.jmba.protocol.back.ProtocolObject;
import ru.bsc.mbs.jmba.protocol.validation.Validatable;
/**
 * @author R. Malyshev
 */
public class BankProductsServiceImpl implements BankProductsService, Validatable {

  public ProtocolObject getBankProductsWithParam(ProtocolObject request) {
    ProtocolObject response = new ProtocolObject() {};
    return response;
  }

  public ProtocolObject getBankProducts() {
    ProtocolObject response = new ProtocolObject() {};
    return response;
  }
}
