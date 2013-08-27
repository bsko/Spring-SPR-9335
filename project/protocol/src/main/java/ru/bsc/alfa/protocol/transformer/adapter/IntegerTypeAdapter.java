package ru.bsc.alfa.protocol.transformer.adapter;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * author: ykhrustalev
 * date: 17.07.12
 */
public class IntegerTypeAdapter implements JsonSerializer<Integer>, JsonDeserializer<Integer> {


  @Override
  public Integer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
    try {
      if (jsonElement.getAsString().isEmpty()) {
        return null;
      }
      return jsonElement.getAsInt();
    } catch (RuntimeException e) {
      throw new JsonParseException(e);
    }
  }

  @Override
  public JsonElement serialize(Integer integer, Type typeOfSrc, JsonSerializationContext jsonSerializationContext) {
    return new JsonPrimitive(integer.toString());
  }
}
