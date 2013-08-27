package ru.bsc.alfa.protocol.elements.responses.transfers;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;
import ru.bsc.alfa.protocol.markup.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * @author R. Malyshev
 */
@OperationId("Transfer:NeedMoreInfo")
public class NeedMoreInfoResponse extends ProtocolMarkupObject {
  private List<Field> specifyingFields;

  public List<Field> getSpecifyingFields() {
    return specifyingFields;
  }

  public void addSpecifyingField(Field f) {
    getNotNullSpecifyingFields().add(f);
  }

  private List<Field> getNotNullSpecifyingFields(){
    return specifyingFields == null ? specifyingFields = new ArrayList<Field>() : specifyingFields;
  }
}
