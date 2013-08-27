package ru.bsc.mbs.jmba.service.bank.products;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bsc.mbs.jmba.protocol.route.AbstractRoute;

/**
 * @author R. Malyshev
 */
public class BankProductsRoute extends AbstractRoute {
  private static final String SERVICE_NAME = "BankProducts";

  @Autowired
  private BankProductsService bankProductsService;

  @Override
  public void configure() {
//    super.configure();
//    addService(SERVICE_NAME, "GetBankProducts", bankProductsService, "getBankProducts");
//    addService(SERVICE_NAME, "GetBankProductsWithParam", bankProductsService, "getBankProductsWithParam");
//    addService("BankProducts", "GetBankProducts", BankProductsServiceImpl.class, "getBankProducts");
//    addService("BankProducts", "GetBankProductsWithParam", BankProductsServiceImpl.class, "getBankProductsWithParam");
//    addService("BankProducts", "GetBankProducts", "bankProductsService", "getBankProducts");
//    addService("BankProducts", "GetBankProductsWithParam", "bankProductsService", "getBankProductsWithParam");
//    addService("BankProducts", "GetBankProducts", BankProductsService.class, "getBankProducts");
//    addService("BankProducts", "GetBankProductsWithParam", BankProductsService.class, "getBankProductsWithParam");
  }
}
