package ru.bsc.mbs.jmba.service.bank.products;

import ru.bsc.mbs.jmba.protocol.back.ProtocolMarkupObject;
import ru.bsc.mbs.jmba.protocol.validation.Validatable;
/**
 * @author R. Malyshev
 */
public class BankProductsServiceImpl implements BankProductsService, Validatable {//extends AbstractService

  public ProtocolMarkupObject getBankProductsWithParam(BankProductsRequest request) {
    ProtocolMarkupObject response = new ProtocolMarkupObject();
    response.setHeader(request.parameters);
    return response;
  }

  public ProtocolMarkupObject getBankProducts() {
    ProtocolMarkupObject response = new ProtocolMarkupObject();
    response.setHeader("some test header");
    return response;
  }
}
