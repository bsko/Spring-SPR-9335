package ru.bsc.mbs.jmba.service.bank.products;


import ru.bsc.mbs.jmba.protocol.back.ProtocolObject;

import java.util.HashMap;

/**
 * @author R. Malyshev
 */
public class BankProductsRequest implements ProtocolObject {

  public String msg;
  public boolean fail;

  public HashMap<String, String> parameters;
}
