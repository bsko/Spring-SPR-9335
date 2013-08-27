package ru.bsc.alfa.protocol.back;

import com.google.gson.annotations.Since;

import java.io.Serializable;

/**
 * Код ошибки JMBP
 * @author Yuri Khrustalyov
 * 28.03.12
 */

public enum FaultCode implements Serializable {

  @Since(1.0) OK(0),
  @Since(1.0) UNKNOWN_ERROR(1),
  @Since(1.0) SESSION_EXPIRED(2),
  @Since(1.0) ACCESS_DENIED(3),
  @Since(1.0) WS_CALL_ERROR(4),
  @Since(1.0) MALFORMED_JMBP_REQUEST(5),
  @Since(1.0) FULL_VERSION_REQUIRED(6);

  @Since(1.0) private int code;

  private FaultCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
