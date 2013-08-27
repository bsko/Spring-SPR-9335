package ru.bsc.alfa.protocol.transformer;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.ws.client.WebServiceIOException;
//import ru.bsc.alfa.config.settings.SettingsManager;
//import ru.bsc.alfa.jmb.base.exception.ErrorCode;
//import ru.bsc.alfa.jmb.base.exception.JMBException;
//import ru.bsc.alfa.jmb.base.exception.ServiceFaultException;
import ru.bsc.alfa.protocol.back.FaultCode;
import ru.bsc.alfa.protocol.elements.ExceptionResponse;
import ru.bsc.alfa.protocol.elements.composite.Fault;

/**
 * author: esedyshev
 */
public class ExceptionHandler
{
  private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);


  /**
   * Обработка исключений и формирование протокольного объекта с информацией об ошибке
   * Вызывается из route в Camel
   * @param exchange
   * @return
   */
  public ExceptionResponse handleException(Exchange exchange) {
    ExceptionResponse response = new ExceptionResponse();
    Fault fault = new Fault();
    Throwable exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);

//    if(exception instanceof JMBException) {
//      JMBException jmbException = (JMBException) exception;
//
//      fault.setFaultMessage(jmbException.getMessage());
//      fault.setFaultCode(getFaultCode(jmbException.getCode()));
//    } else 
//    if(exception instanceof ServiceFaultException) {
//      ServiceFaultException serviceFaultException = (ServiceFaultException)exception;
//      final String message = "";//SettingsManager.getSettings().getProperty(serviceFaultException.getMessageCode());
//      fault.setFaultMessage(message);
//      fault.setFaultCode(FaultCode.WS_CALL_ERROR);
//    } else if (exception instanceof WebServiceIOException) {
//      final String message = SettingsManager.getSettings().getProperty("common.message.error.webserviceFail");
//      fault.setFaultMessage(message);
//      fault.setFaultCode(FaultCode.WS_CALL_ERROR);
//    } else {
      logger.error("Unknown exception", exception);
      fault.setFaultCode(FaultCode.UNKNOWN_ERROR);
//    }

    response.setHeader(fault);

    return response;
  }

  /**
   * Получение протокольного FaultCode по коду исключения
   * @param errorCode
   * @return
   */
//  private FaultCode getFaultCode(ErrorCode errorCode) {
//    FaultCode faultCode = null;
//
//    if(errorCode != null ) {
//      switch (errorCode) {
//        case OK : faultCode = FaultCode.OK; break;
//        case SESSION_EXPIRED: faultCode = FaultCode.SESSION_EXPIRED; break;
//        case ACCESS_DENIED: faultCode = FaultCode.ACCESS_DENIED; break;
//        case JMBP_ISSUE: faultCode = FaultCode.MALFORMED_JMBP_REQUEST; break;
//        case FULL_VERSION_REQUIRED: faultCode = FaultCode.FULL_VERSION_REQUIRED; break;
//        default: faultCode = FaultCode.UNKNOWN_ERROR;
//      }
//    }
//
//    return faultCode;
//  }

  /**
   * Логирование ошибки, когда никак иначе обработать исключение не получается
   * @param exchange
   */
  public void logError(Exchange exchange) {
    Throwable exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
    logger.error("JMBA Exception", exception);
  }
}
