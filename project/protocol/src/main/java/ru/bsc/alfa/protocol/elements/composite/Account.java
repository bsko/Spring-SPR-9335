package ru.bsc.alfa.protocol.elements.composite;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.JMBPIgnore;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Счет
 * @author Yuri Khrustalyov
 * 27.03.12
 */

public class Account implements Serializable {

    /**
     * Номер счета
     */
  @Since(1.0) private String number;

    /**
     * Описание счета
     */
  @Since(1.0) private String description;

    /**
     * Валюта счета
     */
  @Since(1.0) private String currency;

    /**
     * Сумма на счете
     */
  @Since(1.0) private String amount;

    /**
     * Число минорных единиц в сумме
     */
  @Since(1.0) @JMBPIgnore(true)
  private BigDecimal pwd;

    /**
     * Код валюты
     */
  @Since(1.0)
  private String currencyCode;

    /**
     * Тип счета
     */
  @Since(1.0) @JMBPIgnore(true)
  private String type;

  public Account() {
  }

  public String getNumber() {
    return number;
  }

  public Account setNumber(String number) {
    this.number = number;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Account setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getCurrency() {
    return currency;
  }

  public Account setCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public String getAmount() {
    return amount;
  }

  public Account setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public BigDecimal getPwd() {
    return pwd;
  }

  public Account setPwd(BigDecimal pwd) {
    this.pwd = pwd;
    return this;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
