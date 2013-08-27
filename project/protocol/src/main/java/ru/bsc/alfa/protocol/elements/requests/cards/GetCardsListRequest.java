package ru.bsc.alfa.protocol.elements.requests.cards;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * author: esedyshev
 * Запрос на получение списка карт
 */
@OperationId("CustomerCards:GetCardsList")
public class GetCardsListRequest extends ProtocolObject
{
  private static final long serialVersionUID = 5981603030194255715L;
}
