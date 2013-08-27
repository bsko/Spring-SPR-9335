package ru.bsc.alfa.protocol.elements.composite;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.FaultCode;

import java.io.Serializable;

/**
 * Сообщение об ошибке в JMBP
 * @author Yuri Khrustalyov
 * 28.03.12
 */

public class Fault implements Serializable {

    /**
     * Код ошибки
     */
  @Since(1.0) private FaultCode faultCode;

    /**
     * Текст сообщения об ощибке
     */
  @Since(1.0) private String faultMessage;

  public Fault() {
  }

  public String getFaultMessage() {
    return faultMessage;
  }

  public void setFaultMessage(String faultMessage) {
    this.faultMessage = faultMessage;
  }

  public FaultCode getFaultCode() {
    return faultCode;
  }

  public void setFaultCode(FaultCode faultCode) {
    this.faultCode = faultCode;
  }
}
