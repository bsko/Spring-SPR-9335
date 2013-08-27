package ru.bsc.mbs.jmba.service.bank.products;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bsc.mbs.jmba.protocol.route.AbstractRoute;

/**
 * @author R. Malyshev
 */
public class BankProductsRoute extends AbstractRoute {

  @Autowired
  private BankProductsService bankProductsService;

}
