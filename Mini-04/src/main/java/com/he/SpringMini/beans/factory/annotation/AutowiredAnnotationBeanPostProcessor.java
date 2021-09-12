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
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass():clazz;
        Field[] declaredFileds = clazz.getDeclaredFields();
        for(Field field :declaredFileds){
            Value valueAnnotation = field.getAnnotation(Value.class);
            if(valueAnnotation != null){
                String value = valueAnnotation.value();
                //value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);

            }
        }
        return null;

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



}
