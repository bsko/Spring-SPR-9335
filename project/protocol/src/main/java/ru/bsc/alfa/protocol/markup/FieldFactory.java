package ru.bsc.alfa.protocol.markup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * author: esedyshev
 */
public class FieldFactory
{

  public static Field<String> buildTextField(String name, String value) {
    return buildTextField(name, value, null);
  }

  public static Field<String> buildTextField(String name, String value, String description) {
    Field<String> field = new Field<String>();

    field.setName(name);
    field.setDescription(description);
    field.setType(Type.Char);
    field.setRendering(new Rendering(RenderingType.Label));
    field.setValue(value);

    return field;
  }

  public static Field<String> buildAmountField(String name, String value, String description) {
    Field<String> field = new Field<String>();

    field.setName(name);
    field.setDescription(description);
    field.setType(Type.Zoned);
    field.setRendering(new Rendering(RenderingType.Amount));
    field.setValue(value);

    return field;
  }

  public static Field<ArrayList> buildListField(String name, ArrayList<? extends Serializable> list, String description) {
    return buildListField(name, list, description, null);
  }

  public static Field<ArrayList> buildListField(String name, ArrayList<? extends Serializable> list, String description, RenderingType renderingType) {
    Field<ArrayList> field = new Field<ArrayList>();

    field.setName(name);
    field.setDescription(description);
    field.setType(Type.List);
    if(renderingType != null) {
      field.setRendering(new Rendering(renderingType));
    }
    field.setValue(list);

    return field;
  }

  public static Field<Serializable> buildListField(String name, List<? extends Serializable> list, String description) {
    return buildListField(name, list, description, null);
  }

  public static Field<Serializable> buildListField(String name, List<? extends Serializable> list, String description, RenderingType renderingType) {
    if(!(list instanceof Serializable))
      throw new IllegalArgumentException("List must implement Serializable: " + list.getClass().toString());

    Field<Serializable> field = new Field<Serializable>();

    field.setName(name);
    field.setDescription(description);
    field.setType(Type.List);
    if(renderingType != null) {
      field.setRendering(new Rendering(renderingType));
    }
    field.setValue((Serializable)list);

    return field;
  }
}
