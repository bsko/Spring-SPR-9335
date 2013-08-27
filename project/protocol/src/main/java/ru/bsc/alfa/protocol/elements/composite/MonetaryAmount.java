package ru.bsc.alfa.protocol.elements.composite;

/**
 * author: ykhrustalev
 * date: 17.04.12
 */

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.JMBPIgnore;

import java.math.BigDecimal;

/**
 * Класс содержит в себе пару {сумма (в некоторой валюте) ; трехбуквенный код валюты},
 * а также (опционально) дополнительную информацию о количестве минорных единиц - <code>pwd</code>.
 */
public class MonetaryAmount {

  @Since(1.0) private BigDecimal amount;
  @Since(1.0) private String currency;

  @Since(1.0) @JMBPIgnore(true) private BigDecimal pwd;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getPwd() {
    return pwd;
  }

  public void setPwd(BigDecimal pwd) {
    this.pwd = pwd;
  }
}
