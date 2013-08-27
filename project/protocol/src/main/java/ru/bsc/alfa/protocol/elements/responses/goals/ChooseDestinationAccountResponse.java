package ru.bsc.alfa.protocol.elements.responses.goals;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

import java.io.Serializable;
import java.util.HashMap;

/**
 * author: esedyshev
 */
@OperationId("CustomerGoals:ChooseDestinationAccount")
public class ChooseDestinationAccountResponse extends ProtocolMarkupObject<ChooseDestinationAccountResponse.Header>
{
  public static class Header implements Serializable
  {
    @Since(1.0)
    private HashMap<String, String> rates;

    public HashMap<String, String> getRates() {
      return rates;
    }

    public void setRates(HashMap<String, String> rates) {
      this.rates = rates;
    }
  }
  
  public void setRates(HashMap<String, String> rates) {
    if(this.header == null) {
      header = new Header();
    }

    header.setRates(rates);
  }

}
