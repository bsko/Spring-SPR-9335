package ru.bsc.mbs.jmba.protocol.route;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bsc.alfa.protocol.transformer.ExceptionHandler;
import ru.bsc.mbs.jmba.protocol.json.JsonSerializer;
import ru.bsc.mbs.jmba.protocol.json.ProtocolObjectConverter;
import ru.bsc.mbs.jmba.protocol.view.mapping.DefaultViewMapping;

/**
 * @author R. Malyshev
 */
public abstract class AbstractRoute extends RouteBuilder {
  private static String BEAN_INTERFACE_EVENTS_MANAGER = "ru.bsc.alfa.jmb.events.api.JMBAEventsManager";

  private Logger log = LoggerFactory.getLogger(getClass());

  private DefaultViewMapping defaultViewMapping = new DefaultViewMapping();
  private JsonSerializer defaultJsonSerializer = new JsonSerializer(defaultViewMapping);

  @Override
  public void configure() {
    getContext().getTypeConverterRegistry().addFallbackTypeConverter(new ProtocolObjectConverter(), true);

    from("direct:handleGeneralError")
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishExceptionCaughtEvent")
        .bean(ExceptionHandler.class, "handleException");

    from("direct:logErrorAtResponse")
        .bean(ExceptionHandler.class, "logError");
  }

  protected <T> void addService(final String serviceURI, final String methodURI, final Class<T> serviceImpl,
                                   final String method) {
    from(String.format("servlet:///%s/%s", serviceURI, methodURI))
        .doTry()
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishRequestReceivedEvent")
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishRequestParsedEvent")
        .bean(serviceImpl, method)
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishResponseCreatedEvent")
        .doCatch(Throwable.class)
        .to("direct:handleGeneralError")
        .end()
        .doTry()
        .bean(defaultJsonSerializer)
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishResponseSentEvent")
        .doCatch(Throwable.class)
        .to("direct:logErrorAtResponse")
        .end();
  }

  protected <T> void addService(final String serviceURI, final String methodURI, final String serviceBean,
                                final String method) {
    from(String.format("servlet:///%s/%s", serviceURI, methodURI))
        .doTry()
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishRequestReceivedEvent")
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishRequestParsedEvent")
        .beanRef(serviceBean, method)
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishResponseCreatedEvent")
        .doCatch(Throwable.class)
        .to("direct:handleGeneralError")
        .end()
        .doTry()
        .bean(defaultJsonSerializer)
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishResponseSentEvent")
        .doCatch(Throwable.class)
        .to("direct:logErrorAtResponse")
        .end();
  }

  protected <T> void addService(final String serviceURI, final String methodURI, final Object bean,
                                final String method) {
    from(String.format("servlet:///%s/%s", serviceURI, methodURI))
        .doTry()
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishRequestReceivedEvent")
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishRequestParsedEvent")
        .bean(bean, method)
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishResponseCreatedEvent")
        .doCatch(Throwable.class)
        .to("direct:handleGeneralError")
        .end()
        .doTry()
        .bean(defaultJsonSerializer)
        .beanRef(BEAN_INTERFACE_EVENTS_MANAGER, "publishResponseSentEvent")
        .doCatch(Throwable.class)
        .to("direct:logErrorAtResponse")
        .end();
  }
}
