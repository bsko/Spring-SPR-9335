package ru.bsc.alfa.protocol.elements.composite;

import com.google.gson.annotations.Since;
//import ru.bsc.alfa.config.settings.SettingsManager;
//import ru.bsc.alfa.jmb.base.exception.ErrorCode;
//import ru.bsc.alfa.jmb.base.exception.JMBException;
import ru.bsc.alfa.protocol.back.JMBPIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Класс, представляющий собой модель лимита, и одновременно с этим протокольный объект
 *
 * @author R. Malyshev
 */
public class CardLimit implements Serializable, Cloneable {
  private static final long serialVersionUID = 217895482800548137L;

  /**
   * Карта, к которой привязан лимит
   */
  @Since(1.0)
  @JMBPIgnore(true)
  private Card card;

  /**
   * id лимита
   */
  @Since(1.0)
  String id;

  /**
   * Дата начала действия лимита
   */
  @Since(1.0)
  Date startDate;

  /**
   * Дата окончания действия лимита
   */
  @Since(1.0)
  Date endDate;

  /**
   * Тип лимита
   */
  @Since(1.0)
  private ArrayList<Type> type;

  /**
   * Сумма ограничения на разовую операцию в протокольном формате
   */
  @Since(1.0)
  private String singleAmount;

  /**
   * Сумма ограничения на разовую операцию
   */
  @Since(1.0)
  @JMBPIgnore(true)
  private BigDecimal singleAmountOriginal;

  /**
   * Описание валюты ограничения
   */
  @Since(1.0)
  private String singleAmountCurrency;

  /**
   * Код валюты ограничения
   */
  @Since(1.0)
  @JMBPIgnore(true)
  private String singleAmountCurrencyCode;

  /**
   * Описание периода ограничения
   */
  @Since(1.0)
  private String periodDescription;

  /**
   * Код периода ограничения
   */
  @Since(1.0)
  @JMBPIgnore(true)
  private String period;

  /**
   * Сумма ограничения на операции за период в протокольном формате
   */
  @Since(1.0)
  private String periodAmount;

  /**
   * Сумма ограничения на операции за период
   */
  @Since(1.0)
  @JMBPIgnore(true)
  private BigDecimal periodAmountOriginal;

  /**
   * Описание валюты ограничения за период
   */
  @Since(1.0)
  private String periodAmountCurrency;

  /**
   * Код валюты ограничения за период
   */
  @Since(1.0)
  @JMBPIgnore(true)
  private String periodAmountCurrencyCode;

  /**
   * Описание включаемых стран
   */
  @Since(1.0)
  private String inclusiveCountryDescription;

  /**
   * Код включаемых стран
   */
  @Since(1.0)
  @JMBPIgnore(true)
  private String inclusiveCountry;

  /**
   * Группа стран
   */
  @Since(1.0)
  @JMBPIgnore(true)
  private String countryGroup;

  /**
   * Список стран
   */
  @Since(1.0)
  private ArrayList<Country> countries;

  public Card getCard() {
    return card;
  }

  public CardLimit setCard(Card card) {
    this.card = card;
    return this;
  }

  public String getId() {
    return id;
  }

  public CardLimit setId(String id) {
    this.id = id;
    return this;
  }

  public Date getStartDate() {
    return startDate;
  }

  public CardLimit setStartDate(Date startDate) {
    this.startDate = startDate;
    return this;
  }

  public Date getEndDate() {
    return endDate;
  }

  public CardLimit setEndDate(Date endDate) {
    this.endDate = endDate;
    return this;
  }

  public List<Type> getType() {
    if (type == null)
      return Collections.emptyList();
    else
      return type;
  }

  public CardLimit addType(String code, String description) {
    if (this.type == null)
      this.type = new ArrayList<Type>();
    this.type.add(new Type(code, description));
    return this;
  }

  public BigDecimal getSingleAmount() {
    return singleAmountOriginal;
  }

  public CardLimit setSingleAmountFromProtocolFormat(String singleAmount) {
    this.singleAmountOriginal = parseAmount(singleAmount);
    this.singleAmount = singleAmount;
    return this;
  }

  public CardLimit setSingleAmount(BigDecimal singleAmount) {
    this.singleAmountOriginal = singleAmount;
    this.singleAmount = formatAmount(singleAmount);
    return this;
  }

  public String getSingleAmountCurrency() {
    return singleAmountCurrency;
  }

  public CardLimit setSingleAmountCurrency(String singleAmountCurrency) {
    this.singleAmountCurrency = singleAmountCurrency;
    return this;
  }

  public String getSingleAmountCurrencyCode() {
    return singleAmountCurrencyCode;
  }

  public CardLimit setSingleAmountCurrencyCode(String singleAmountCurrencyCode) {
    this.singleAmountCurrencyCode = singleAmountCurrencyCode;
    return this;
  }

  public String getPeriodDescription() {
    return periodDescription;
  }

  public CardLimit setPeriodDescription(String periodDescription) {
    this.periodDescription = periodDescription;
    return this;
  }

  public String getPeriod() {
    return period;
  }

  public CardLimit setPeriod(String period) {
    this.period = period;
    return this;
  }

  public BigDecimal getPeriodAmount() {
    return periodAmountOriginal;
  }

  public CardLimit setPeriodAmountFromProtocolFormat(String periodAmount) {
    this.periodAmountOriginal = parseAmount(periodAmount);
    this.periodAmount = periodAmount;
    return this;
  }

  public CardLimit setPeriodAmount(BigDecimal periodAmount) {
    this.periodAmountOriginal = periodAmount;
    this.periodAmount = formatAmount(periodAmount);
    return this;
  }

  public String getPeriodAmountCurrency() {
    return periodAmountCurrency;
  }

  public CardLimit setPeriodAmountCurrency(String periodAmountCurrency) {
    this.periodAmountCurrency = periodAmountCurrency;
    return this;
  }

  public String getPeriodAmountCurrencyCode() {
    return periodAmountCurrencyCode;
  }

  public CardLimit setPeriodAmountCurrencyCode(String periodAmountCurrencyCode) {
    this.periodAmountCurrencyCode = periodAmountCurrencyCode;
    return this;
  }

  public String getInclusiveCountryDescription() {
    return inclusiveCountryDescription;
  }

  public CardLimit setInclusiveCountryDescription(String inclusiveCountryDescription) {
    this.inclusiveCountryDescription = inclusiveCountryDescription;
    return this;
  }

  public String getInclusiveCountry() {
    return inclusiveCountry;
  }

  public CardLimit setInclusiveCountry(String inclusiveCountry) {
    this.inclusiveCountry = inclusiveCountry;
    return this;
  }

  public String getCountryGroup() {
    return countryGroup;
  }

  public void setCountryGroup(String countryGroup) {
    this.countryGroup = countryGroup;
  }

  public List<Country> getCountries() {
    if (countries == null)
      return Collections.emptyList();
    else
      return countries;
  }

  public CardLimit addCountry(String code, String description) {
    if (this.countries == null)
      this.countries = new ArrayList<Country>();
    this.countries.add(new Country(code, description));
    return this;
  }

  public class Type implements Serializable {
    private static final long serialVersionUID = 7491900758342171398L;

    @Since(1.0)
    String value;

    @Since(1.0)
    String description;

    private Type(String value, String description) {
      this.value = value;
      this.description = description;
    }

    public String getValue() {
      return value;
    }

    public String getDescription() {
      return description;
    }
  }

  public class Country implements Serializable {
    private static final long serialVersionUID = -8030855606751670001L;

    @Since(1.0)
    private String value;

    @Since(1.0)
    private String description;

    private Country(String value, String description) {
      this.value = value;
      this.description = description;
    }

    public String getValue() {
      return value;
    }

    public String getDescription() {
      return description;
    }
  }

  /**
   * Форматирует сумму согласно протоколу
   *
   * @param amount
   * @return
   */
  private String formatAmount(BigDecimal amount) {
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();//SettingsManager.getDecimalFormatSymbols();
    DecimalFormat df = new DecimalFormat(",##0", symbols);
    df.setRoundingMode(RoundingMode.UNNECESSARY);
    return df.format(amount);
  }

  /**
   * Парсит сумму из протокольного формата
   *
   * @param amount
   * @return
   */
  private BigDecimal parseAmount(String amount) {
    DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(new Locale("ru"));//SettingsManager.getDefaultLocale());
    df.setParseBigDecimal(true);
    df.setDecimalFormatSymbols(new DecimalFormatSymbols());//SettingsManager.getDecimalFormatSymbols());
    try {
      return (BigDecimal) df.parse(amount);
    } catch (ParseException e) {
      return null;
//      throw new JMBException(ErrorCode.JMBP_ISSUE, e);
    }
  }

  @Override
  public CardLimit clone() throws CloneNotSupportedException {
    CardLimit clone = (CardLimit) super.clone();
    clone.startDate = startDate != null ? (Date) startDate.clone() : null;
    clone.endDate = endDate != null ? (Date) endDate.clone() : null;
    clone.type = type != null ? (ArrayList<Type>) type.clone() : null;
    clone.countries = countries != null ? (ArrayList<Country>) countries.clone() : null;
    return clone;
  }

  /**
   * За уникальное свойство лимита принимается его id
   *
   * @param o
   * @return
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CardLimit)) return false;

    CardLimit cardLimit = (CardLimit) o;

    if (id != null ? !id.equals(cardLimit.id) : cardLimit.id != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
