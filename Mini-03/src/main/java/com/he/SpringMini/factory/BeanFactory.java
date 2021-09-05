package com.he.SpringMini.factory;


import com.he.SpringMini.BeanException;
import javafx.beans.binding.ObjectExpression;

public interface BeanFactory {
    /**
     * 无参构造
     *
     * @param name
     * @return
     * @throws BeanException
     */
    Object getBean(String name) throws BeanException;

    /**
     * 有参构造
     *
     * @param name
     * @param args
     * @return
     * @throws BeanException
     */
    Object getBean(String name, Object... args) throws BeanException;
}
