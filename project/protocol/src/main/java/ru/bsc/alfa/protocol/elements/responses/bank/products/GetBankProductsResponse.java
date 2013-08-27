package ru.bsc.alfa.protocol.elements.responses.bank.products;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;
import ru.bsc.alfa.protocol.elements.composite.Account;

import java.util.List;

/**
 * @author R. Malyshev
 */
@OperationId("BankProducts:BankProducts")
public class GetBankProductsResponse extends ProtocolMarkupObject {
  private static final long serialVersionUID = 1202568052186980628L;

  @Since(1.0)
  private List<Account> accounts;

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }
}
