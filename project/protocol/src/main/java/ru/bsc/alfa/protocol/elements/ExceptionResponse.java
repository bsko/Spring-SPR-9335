package ru.bsc.alfa.protocol.elements;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;
import ru.bsc.alfa.protocol.elements.composite.Fault;

/**
 * author: esedyshev
 */
@OperationId("Exception")
public class ExceptionResponse extends ProtocolMarkupObject<Fault>
{
  public ExceptionResponse() {
  }
}
