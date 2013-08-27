package ru.bsc.alfa.protocol.back;

import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * author esedyshev
 */
public class ClassScanner
{
  final private static Logger logger = LoggerFactory.getLogger(ClassScanner.class);

  /**
   * Получение классов из заданного пакета с заданной аннотацией
   * @param basePackage пакет
   * @param annotationType аннотация
   * @return
   */
  public List<Class<?>> getClasses(String basePackage, Class<? extends Annotation> annotationType) {
    LinkedList<Class<?>> res = new LinkedList<Class<?>>();
    ClassLoader cl = getClass().getClassLoader();
    
    Enumeration bundleClasses = FrameworkUtil.getBundle(OperationMapping.class).findEntries("/", "*.class", true);
    while(bundleClasses.hasMoreElements()) {
      URL url = (URL) bundleClasses.nextElement();
      String path = url.toExternalForm().replace('/','.');
      int index = path.indexOf(basePackage);
      
      if(index >= 0 ) {
        String className = path.substring(index, path.length()-6);

        try {
          Class<?> clazz = Class.forName(className, false, cl);

          if(clazz.isAnnotationPresent(annotationType)) {
            res.add(clazz);
          }
        } catch (ClassNotFoundException e) {
          logger.error("Can't load class " + className, e);
        }
      }
      
    }

    return res;
  }
}
