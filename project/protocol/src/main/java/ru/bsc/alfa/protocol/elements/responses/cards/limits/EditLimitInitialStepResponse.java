package ru.bsc.alfa.protocol.elements.responses.cards.limits;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

/**
 * @author R. Malyshev
 */
@OperationId("CustomerCardLimits:EditLimitInitialStepResult")
public class EditLimitInitialStepResponse extends ProtocolMarkupObject {
  private static final long serialVersionUID = 2907506402289522365L;

  @Since(1.0)
  private String cardId;

  @Since(1.0)
  private String limitId;

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public String getLimitId() {
    return limitId;
  }

  public void setLimitId(String limitId) {
    this.limitId = limitId;
  }
}
