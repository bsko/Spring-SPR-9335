package ru.bsc.alfa.protocol.elements.requests.cards.limits;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;
import ru.bsc.alfa.protocol.elements.composite.NameValues;

import java.util.ArrayList;

/**
 * @author R. Malyshev
 */
@OperationId("CustomerCardLimits:CreateLimitConfirmationStep")
public class CreateLimitConfirmationStepRequest extends ProtocolObject {
  private static final long serialVersionUID = -1741582446265392769L;

  @Since(1.0)
  private String cardId;

  @Since(1.0)
  private ArrayList<NameValues> fieldValues;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getCardId() {
    return cardId;
  }

  public ArrayList<NameValues> getFieldValues() {
    return fieldValues;
  }
}
