package ru.bsc.mbs.jmba.service.bank.products;

import ru.bsc.mbs.jmba.protocol.validation.Validatable;
/**
 * @author R. Malyshev
 */
public class BankProductsServiceImpl implements BankProductsService, Validatable {

  public String getBankProductsWithParam(String request) {
    return "getBankProductsWithParam";
  }

  public String getBankProducts() {
    return "getBankProducts";
  }
}
