package ru.bsc.alfa.protocol.elements.composite;

import java.io.Serializable;
import java.util.Date;

/**
 * Финансовая цель
 * @author ykhrustalev
 * date: 17.04.12
 */
public class Goal implements Serializable {

    /**
     * Название цели
     */
  private String name;

    /**
     * Накопленная сумма
     */
  private String scraped;

    /**
     * Выполнить к дате
     */
  private Date dueDate;

    /**
     * Рекомендуемый месячный платеж
     */
  private String recommendedMonthlyPayment;

    /**
     *  Статус цели
     */
  private String status;

    /**
     * Номер счета
     */
  private String accountNumber;

    /**
     * Идентификатор цели
     */
  private String id;

  public String getName() {
    return name;
  }

  public Goal setName(String name) {
    this.name = name;
    return this;
  }

  public String getScraped() {
    return scraped;
  }

  public Goal setScraped(String scraped) {
    this.scraped = scraped;
    return this;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public Goal setDueDate(Date dueDate) {
    this.dueDate = dueDate;
    return this;
  }

  public String getRecommendedMonthlyPayment() {
    return recommendedMonthlyPayment;
  }

  public Goal setRecommendedMonthlyPayment(String recommendedMonthlyPayment) {
    this.recommendedMonthlyPayment = recommendedMonthlyPayment;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public Goal setStatus(String status) {
    this.status = status;
    return this;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public Goal setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  public String getId() {
    return id;
  }

  public Goal setId(String id) {
    this.id = id;
    return this;
  }
}
