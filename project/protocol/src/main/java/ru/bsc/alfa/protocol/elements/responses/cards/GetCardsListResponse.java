package ru.bsc.alfa.protocol.elements.responses.cards;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

/**
 * author: esedyshev
 * Ответ со списком карт
 */
@OperationId("CustomerCards:CardsList")
public class GetCardsListResponse extends ProtocolMarkupObject
{
  private static final long serialVersionUID = -6340299881248575510L;
}
