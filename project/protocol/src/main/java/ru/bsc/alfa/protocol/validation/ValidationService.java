package ru.bsc.alfa.protocol.validation;

import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * @author R. Malyshev
 */
public interface ValidationService {
  public void validate(ProtocolObject protocolObject);
}
