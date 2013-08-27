package ru.bsc.alfa.protocol.transformer.adapter;

import com.google.gson.*;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.reflect.Type;

public class IntegerTypeAdapterTest {

  private IntegerTypeAdapter integerTypeAdapter;
  private JsonSerializationContext jsonSerializationContext;
  private JsonDeserializationContext jsonDeserializationContext;
    
  @Before
  public void init(){
    integerTypeAdapter = new IntegerTypeAdapter();

    jsonSerializationContext = new JsonSerializationContext() {
        @Override
        public JsonElement serialize(Object o) {
            return null;
        }

        @Override
        public JsonElement serialize(Object o, Type type) {
            return null;
        }
    };

    jsonDeserializationContext = new JsonDeserializationContext() {
        @Override
        public <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return null;
        }
    } ;
  }

  @Test
  public void testSerialize(){
      Assert.assertEquals(new JsonPrimitive("123"), integerTypeAdapter.serialize(new Integer("123"), Integer.class, jsonSerializationContext));
      Assert.assertEquals(new JsonPrimitive("-123"), integerTypeAdapter.serialize(new Integer("-123"), Integer.class, jsonSerializationContext));
      Assert.assertEquals(new JsonPrimitive("0"), integerTypeAdapter.serialize(new Integer("0"), Integer.class, jsonSerializationContext));
      Assert.assertEquals(new JsonPrimitive(Integer.toString(Integer.MAX_VALUE)), integerTypeAdapter.serialize(Integer.MAX_VALUE, Integer.class, jsonSerializationContext));
      Assert.assertEquals(new JsonPrimitive(Integer.toString(Integer.MIN_VALUE)), integerTypeAdapter.serialize(Integer.MIN_VALUE, Integer.class, jsonSerializationContext));

      try{
        Integer nullInt = null;
        integerTypeAdapter.serialize(nullInt, Integer.class, jsonSerializationContext);
        Assert.fail("There should be an exception!");
      } catch (NullPointerException e){

      }

  }

  @Test
  public void testDeserialize(){
     Assert.assertEquals(new Integer("123"), integerTypeAdapter.deserialize(new JsonPrimitive("123"), Integer.class, jsonDeserializationContext));
     Assert.assertEquals(new Integer("-123"), integerTypeAdapter.deserialize(new JsonPrimitive("-123"), Integer.class, jsonDeserializationContext));
     Assert.assertEquals(new Integer("0"), integerTypeAdapter.deserialize(new JsonPrimitive("0"), Integer.class, jsonDeserializationContext));
     Assert.assertEquals(new Integer(Integer.MAX_VALUE), integerTypeAdapter.deserialize(new JsonPrimitive(Integer.toString(Integer.MAX_VALUE)), Integer.class, jsonDeserializationContext));
     Assert.assertEquals(new Integer(Integer.MIN_VALUE), integerTypeAdapter.deserialize(new JsonPrimitive(Integer.toString(Integer.MIN_VALUE)), Integer.class, jsonDeserializationContext));
     Assert.assertEquals(null, integerTypeAdapter.deserialize(new JsonPrimitive(""), Integer.class, jsonDeserializationContext));

    try {
      JsonPrimitive jsonPrimitive = null;
      integerTypeAdapter.deserialize(jsonPrimitive, Integer.class, jsonDeserializationContext);
      Assert.fail("There should be an exception!");
    } catch (JsonParseException e) {

    }

    try {
      integerTypeAdapter.deserialize(new JsonPrimitive("abc"), Integer.class, jsonDeserializationContext);
      Assert.fail("There should be an exception!");
    } catch (JsonParseException e) {

    }

    try {
      JsonObject jsonObject = new JsonObject();
      jsonObject.add("test", new JsonPrimitive("123"));
      integerTypeAdapter.deserialize(jsonObject, Integer.class, jsonDeserializationContext);
      Assert.fail("There should be an exception!");
    } catch (JsonParseException e) {

    }

    try {
      integerTypeAdapter.deserialize(JsonNull.INSTANCE, Integer.class, jsonDeserializationContext);
      Assert.fail("There should be an exception!");
    } catch (JsonParseException e) {

    }

    try {
      JsonArray jsonArray = new JsonArray();
      jsonArray.add(new JsonPrimitive("123"));
      jsonArray.add(new JsonPrimitive("567"));
      integerTypeAdapter.deserialize(jsonArray, Integer.class, jsonDeserializationContext);
      Assert.fail("There should be an exception!");
    } catch (JsonParseException e) {

    }

    try {
      integerTypeAdapter.deserialize(new JsonPrimitive("123 00"), Integer.class, jsonDeserializationContext);
      Assert.fail("There should be an exception!");
    } catch (JsonParseException e) {

    }

    try {
      integerTypeAdapter.deserialize(new JsonPrimitive("10000000000000"), Integer.class, jsonDeserializationContext);
      Assert.fail("There should be an exception!");
    } catch (JsonParseException e) {

    }

  }
}