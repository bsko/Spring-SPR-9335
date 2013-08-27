package ru.bsc.alfa.protocol.elements.responses;

import ru.bsc.alfa.protocol.elements.composite.ConfirmationType;
import ru.bsc.alfa.protocol.markup.Field;

import java.util.List;

/**
 * author: esedyshev
 */
public interface TransferConfirmationResponse
{
  public void setRegistered(boolean registered);

  public void setReference(String reference);

  public void setConfirmationType(ConfirmationType confirmationType);

  public void setFields(List<Field> fields);

  public void addField(Field field);

  public void setPasswordLength(Integer maxLen);
}
