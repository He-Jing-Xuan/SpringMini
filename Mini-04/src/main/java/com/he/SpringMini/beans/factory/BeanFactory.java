package com.he.SpringMini.beans.factory;


import com.he.SpringMini.beans.BeanException;

public interface BeanFactory {


    Object getBean(String name) throws BeanException;

    Object getBean(String name, Object... args) throws BeanException;

    <T> T getBean(String name,Class<T> requiredType);

    <T> T getBean(Class<T> requiredType) throws BeanException;


}
