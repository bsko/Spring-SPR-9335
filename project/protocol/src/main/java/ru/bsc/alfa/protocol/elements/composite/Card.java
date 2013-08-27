package ru.bsc.alfa.protocol.elements.composite;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.JMBPIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * author: esedyshev
 */
public class Card implements Serializable
{
  private static final long serialVersionUID = -7941698872306036082L;

  /**
   * Id карты
   */
  @Since(1.0)
  private String id;
  /**
   * Название карты
   */
  @Since(1.0)
  private String name;
  /**
   * Номер карты (с наложенной маской вида 1234 56** **** 7890)
   */
  @Since(1.0)
  private String number;

  @JMBPIgnore(true)
  private String unmaskedNumber;

  @JMBPIgnore(true)
  private Date expirationDate;

  @JMBPIgnore(true)
  private Date issueDate;

  /**
   * Название платежной системы
   */
  @Since(1.0)
  private String ips;
  /**
   * Счет, к которому привязана карта
   */
  @Since(1.0)
  private Account account;

  /**
   * Тип карты - дебитовая/кредитная
   */
  @Since(1.0)
  private String type;

  /**
   * Подключена ли к карте услуга Альфа-Чек
   */
  @Since(1.0)
  private Boolean alfaCheck;

  /**
   * На какой номер подключена услуга Альфа-Чек
   */
  @Since(1.0)
  private String alfaCheckPhoneNumber;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getIps() {
    return ips;
  }

  public void setIps(String ips) {
    this.ips = ips;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public String getUnmaskedNumber() {
    return unmaskedNumber;
  }

  public void setUnmaskedNumber(String unmaskedNumber) {
    this.unmaskedNumber = unmaskedNumber;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  public Date getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(Date issueDate) {
    this.issueDate = issueDate;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getAlfaCheck() {
    return alfaCheck;
  }

  public void setAlfaCheck(Boolean alfaCheck) {
    this.alfaCheck = alfaCheck;
  }

  public String getAlfaCheckPhoneNumber() {
    return alfaCheckPhoneNumber;
  }

  public void setAlfaCheckPhoneNumber(String alfaCheckPhoneNumber) {
    this.alfaCheckPhoneNumber = alfaCheckPhoneNumber;
  }
}
