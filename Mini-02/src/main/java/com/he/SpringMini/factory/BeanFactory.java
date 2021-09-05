package com.he.SpringMini.factory;

import com.he.SpringMini.BeanException;

public interface BeanFactory {
    Object getBean(String name) throws BeanException;
}
