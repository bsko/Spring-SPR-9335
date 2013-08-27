package ru.bsc.alfa.protocol.back;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Yuri Khrustalyov
 * 27.03.12
 */

public class OperationMapping {

  final private static Logger logger = LoggerFactory.getLogger(OperationMapping.class);

  private static Map<String, Class<? extends ProtocolObject>> mapping = new HashMap<String, Class<? extends ProtocolObject>>();

  private List<String> scanPackages;
  private ClassScanner classScanner = new ClassScanner();

  public void init() {

    for (String pkg : scanPackages) {
      for (Class<?> clazz : classScanner.getClasses(pkg, OperationId.class)) {

        String operationId = clazz.getAnnotation(OperationId.class).value();

        if (mapping.containsKey(operationId)) {
          logger.warn("Doubled operationId is found!!! operationId = " + operationId);
        }

        mapping.put(operationId, (Class<? extends ProtocolObject>) clazz);
      }
    }
  }

  public Class<? extends ProtocolObject> getType(final String operationId) {
    return mapping.get(operationId);
  }

  public List<String> getScanPackages() {
    return scanPackages;
  }

  public void setScanPackages(List<String> scanPackages) {
    this.scanPackages = scanPackages;
  }
}
