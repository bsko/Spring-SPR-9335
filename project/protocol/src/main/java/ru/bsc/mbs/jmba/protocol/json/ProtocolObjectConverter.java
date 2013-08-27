package ru.bsc.mbs.jmba.protocol.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.support.TypeConverterSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bsc.mbs.jmba.protocol.back.ProtocolObject;

import java.io.IOException;

/**
 * @author R. Malyshev
 */
public class ProtocolObjectConverter extends TypeConverterSupport {
  private static Logger log = LoggerFactory.getLogger(ProtocolObjectConverter.class);
  private ObjectMapper objectMapper = new ObjectMapper();

  public <T> T convertTo(Class<T> type, Exchange exchange, Object value) {
    if (ProtocolObject.class.isAssignableFrom(type)) {
      try {
        String request = exchange.getIn().getBody(String.class);
        log.trace("Received JSON request: " + request);
        T v = objectMapper.readValue(request, type);
        if(v == null) {
          log.error("Deserialized value is null");
          throw new IllegalStateException("Deserialized value is null");
        }
        return v;
      } catch (IOException e) {
        log.error("Can't convert JSON to ProtocolObject", e);
        throw new RuntimeException(e);
      }
    }

    return null;
  }
}
