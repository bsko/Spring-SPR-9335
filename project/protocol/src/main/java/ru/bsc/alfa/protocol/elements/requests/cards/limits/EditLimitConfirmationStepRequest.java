package ru.bsc.alfa.protocol.elements.requests.cards.limits;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;
import ru.bsc.alfa.protocol.elements.composite.NameValuePair;

import java.util.ArrayList;

/**
 * @author R. Malyshev
 */
@OperationId("CustomerCardLimits:EditLimitConfirmationStep")
public class EditLimitConfirmationStepRequest extends ProtocolObject {
  private static final long serialVersionUID = 4791677425240818275L;

  @Since(1.0)
  private String cardId;

  @Since(1.0)
  private String limitId;

  private ArrayList<NameValuePair> fieldValues;

  public String getCardId() {
    return cardId;
  }

  public String getLimitId() {
    return limitId;
  }

  public ArrayList<NameValuePair> getFieldValues() {
    return fieldValues;
  }
}
