package ru.bsc.mbs.jmba.protocol.view.mapping;

//import ru.bsc.mbs.jmba.domain.BankProduct;
import ru.bsc.mbs.jmba.protocol.view.BankProductShortView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author R. Malyshev
 */
public class DefaultViewMapping extends HashMap<Class<?>, Class<?>> {
  private static final long serialVersionUID = -7183188460274125699L;

  public DefaultViewMapping() {
    put(BankProductShortView.class, BankProductShortView.class);
  }

  public DefaultViewMapping(Map<? extends Class<?>, ? extends Class<?>> m) {
    super(m);
  }
}
