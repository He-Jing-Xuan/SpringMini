package com.he.SpringMini.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.PropertyValues;
import com.he.SpringMini.beans.factory.BeanFactory;
import com.he.SpringMini.beans.factory.BeanFactoryAware;
import com.he.SpringMini.beans.factory.config.ConfigurableListableBeanFactory;
import com.he.SpringMini.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.he.SpringMini.util.ClassUtils;

import java.lang.reflect.Field;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/10 9:52 下午
 * @Version 1.0
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private ConfigurableListableBeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeanException {
          this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeanException {
        // 1. 处理注解 @Value
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass():clazz;
        Field[] declaredFileds = clazz.getDeclaredFields();
        for(Field field :declaredFileds){
            Value valueAnnotation = field.getAnnotation(Value.class);
            //获取属性注解的值， 并填充属性
            if(valueAnnotation != null){
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);

            }
        }
        // 2. 处理注解 @Autowired
        for (Field field : declaredFileds) {

            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            // 处理 对象属性填充
            if (null != autowiredAnnotation) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if (null != qualifierAnnotation) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }

        return pvs;

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeanException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeanException {
        return false;
    }


}
