package com.asteelflash.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.StringUtils;

/**
 * 覆写BeanUtils 是为了过滤null值的拷贝。如果一个属性不存在，则不要为该值进行copy.
 * 
 * @author Shawn
 *
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {
  /**
   * Copy the property values of the given source bean into the target bean. Note: The source and
   * target classes do not have to match or even be derived from each other, as long as the
   * properties match. Any bean properties that the source bean exposes but the target bean does not
   * will silently be ignored. This is just a convenience method. For more complex transfer needs,
   * consider using a full BeanWrapper.
   * 
   * @param source the source bean
   * @param target the target bean
   * @throws BeansException if the copying failed
   * @see BeanWrapper
   */
  public static void copyProperties(Object source, Object target) throws BeansException {
    Class<?> actualEditable = target.getClass();
    PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
    for (PropertyDescriptor targetPd : targetPds) {
      if (targetPd.getWriteMethod() != null) {
        PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
        if (sourcePd != null && sourcePd.getReadMethod() != null) {
          Method readMethod = null;
          try {
            readMethod = sourcePd.getReadMethod();
            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
              readMethod.setAccessible(true);
            }
            Object value = readMethod.invoke(source);
            // 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
            if (!StringUtils.isEmpty(value)) {
              Method writeMethod = targetPd.getWriteMethod();
              if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                writeMethod.setAccessible(true);
              }
              writeMethod.invoke(target, value);
            }
          } catch (Throwable ex) {
            throw new FatalBeanException(
                "Could not copy properties from source to target [" + readMethod + "]", ex);
          }
        }
      }
    }
  }
}
