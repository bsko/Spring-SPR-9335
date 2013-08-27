package ru.bsc.alfa.protocol.elements.responses.cards.limits;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

/**
 * @author R. Malyshev
 */
@OperationId("CustomerCardLimits:CreateLimitInitialStepResult")
public class CreateLimitInitialStepResponse extends ProtocolMarkupObject {
  private static final long serialVersionUID = 3427862782887592754L;

  @Since(1.0)
  private String cardId;

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }
}
