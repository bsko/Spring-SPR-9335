package ru.bsc.mbs.jmba.protocol.view;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author R. Malyshev
 */
public interface BankProductShortView {
  @JsonIgnore String getCurrency();
}
