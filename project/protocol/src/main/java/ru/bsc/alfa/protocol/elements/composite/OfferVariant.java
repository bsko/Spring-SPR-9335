package ru.bsc.alfa.protocol.elements.composite;

import com.google.gson.annotations.Since;

import java.io.Serializable;
import java.util.Date;

/**
 * Предодобренное предложение
 * author: esedyshev
 */
public class OfferVariant implements Serializable
{
  @Since(1.0)
  private Integer offerId;
  @Since(1.0)
  private String productGroup;
  @Since(1.0)
  private String comments;

  @Since(1.0)
  private Short offerSequence;
  @Since(1.0)
  private String minimumAmount;
  @Since(1.0)
  private String maximumAmount;
  @Since(1.0)
  private String minimumTerm;
  @Since(1.0)
  private String maximumTerm;
  @Since(1.0)
  private String yearlyInterestRate;
  @Since(1.0)
  private String currencyCode;
  @Since(1.0)
  private String cardCategory;
  @Since(1.0)
  private String monthlyCommissionPct;
  @Since(1.0)
  private String yearlyCommission;
  @Since(1.0)
  private String gracePeriod;
  @Since(1.0)
  private Date expiryDate;


  public Integer getOfferId() {
    return offerId;
  }

  public void setOfferId(Integer offerId) {
    this.offerId = offerId;
  }

  public String getProductGroup() {
    return productGroup;
  }

  public void setProductGroup(String productGroup) {
    this.productGroup = productGroup;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Short getOfferSequence() {
    return offerSequence;
  }

  public void setOfferSequence(Short offerSequence) {
    this.offerSequence = offerSequence;
  }

  public String getMinimumAmount() {
    return minimumAmount;
  }

  public void setMinimumAmount(String minimumAmount) {
    this.minimumAmount = minimumAmount;
  }

  public String getMaximumAmount() {
    return maximumAmount;
  }

  public void setMaximumAmount(String maximumAmount) {
    this.maximumAmount = maximumAmount;
  }

  public String getMinimumTerm() {
    return minimumTerm;
  }

  public void setMinimumTerm(String minimumTerm) {
    this.minimumTerm = minimumTerm;
  }

  public String getMaximumTerm() {
    return maximumTerm;
  }

  public void setMaximumTerm(String maximumTerm) {
    this.maximumTerm = maximumTerm;
  }

  public String getYearlyInterestRate() {
    return yearlyInterestRate;
  }

  public void setYearlyInterestRate(String yearlyInterestRate) {
    this.yearlyInterestRate = yearlyInterestRate;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public String getCardCategory() {
    return cardCategory;
  }

  public void setCardCategory(String cardCategory) {
    this.cardCategory = cardCategory;
  }

  public String getMonthlyCommissionPct() {
    return monthlyCommissionPct;
  }

  public void setMonthlyCommissionPct(String monthlyCommissionPct) {
    this.monthlyCommissionPct = monthlyCommissionPct;
  }

  public String getYearlyCommission() {
    return yearlyCommission;
  }

  public void setYearlyCommission(String yearlyCommission) {
    this.yearlyCommission = yearlyCommission;
  }

  public String getGracePeriod() {
    return gracePeriod;
  }

  public void setGracePeriod(String gracePeriod) {
    this.gracePeriod = gracePeriod;
  }

  public Date getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(Date expiryDate) {
    this.expiryDate = expiryDate;
  }
}
