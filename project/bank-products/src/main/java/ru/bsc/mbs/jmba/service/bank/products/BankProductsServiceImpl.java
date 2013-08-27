package ru.bsc.mbs.jmba.service.bank.products;

//import org.springframework.beans.factory.annotation.Autowired;
//import ru.bsc.alfa.jmb.system.services.AbstractService;
//import ru.bsc.alfa.jmb.ws.adapter.api.CustomerAccountBalanceServiceClient;
//import ru.bsc.mbs.jmba.domain.BankProduct;
import ru.bsc.mbs.jmba.protocol.back.ProtocolMarkupObject;
import ru.bsc.mbs.jmba.protocol.validation.Validatable;

//import java.io.Serializable;
//import java.math.BigDecimal;

/**
 * @author R. Malyshev
 */
public class BankProductsServiceImpl implements BankProductsService, Validatable {//extends AbstractService

//  @Autowired
//  public void setAccountBalanceServiceClient(CustomerAccountBalanceServiceClient accountBalanceServiceClient) {
//    super.setAccountBalanceServiceClient(accountBalanceServiceClient);
//  }

  public ProtocolMarkupObject getBankProductsWithParam(BankProductsRequest request) {
    ClassLoader cl = this.getClass().getClassLoader();
    ClassLoader cl1 = Thread.currentThread()
        .getContextClassLoader();
    Class c = null;
    Class c1 = null;
    try {
      c = cl.loadClass("ru.bsc.mbs.jmba.protocol.validation.Validatable");
      c1 = cl1.loadClass("ru.bsc.mbs.jmba.protocol.validation.Validatable");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    ProtocolMarkupObject response = new ProtocolMarkupObject();
    response.setHeader(request.parameters);
    return response;
  }

  public ProtocolMarkupObject getBankProducts() {
//    List<Account> list = getCustomerAccountsList(new WSCommonParameters(), "sdf");
    ProtocolMarkupObject response = new ProtocolMarkupObject();
//    BankProduct b = new BankProduct();
//    b.setNumber("12344567");
//    b.setAmount(new BigDecimal(100));
//    b.setCurrency("RUR");
    response.setHeader("");
    return response;
  }
}
