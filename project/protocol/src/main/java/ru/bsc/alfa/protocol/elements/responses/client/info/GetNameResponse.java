package ru.bsc.alfa.protocol.elements.responses.client.info;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;

import java.io.Serializable;

/**
 * @author R. Malyshev
 */
@OperationId("ClientInfo:GetNameResult")
public class GetNameResponse extends ProtocolMarkupObject<GetNameResponse.Name> {
  private static final long serialVersionUID = 1677605551959126532L;

  public class Name implements Serializable {
    private static final long serialVersionUID = 8668854641337831775L;
    private String surname;
    private String firstName;
    private String patronymic;
  }

  private Name getName() {
    if (getHeader() == null)
      setHeader(new Name());
    return getHeader();
  }

  public void setSurname(String surname) {
    getName().surname = surname;
  }

  public void setFirstName(String firstName) {
    getName().firstName = firstName;
  }

  public void setPatronymic(String patronymic) {
    getName().patronymic = patronymic;
  }
}
