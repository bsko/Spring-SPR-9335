package ru.bsc.mbs.jmba.service.bank.products;

/**
 * @author R. Malyshev
 */
public interface BankProductsService {
  
  String getBankProductsWithParam(String request);
  
  String getBankProducts();
}
