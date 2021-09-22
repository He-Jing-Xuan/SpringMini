package com.example.mini02;

import com.example.UserService;
import com.he.SpringMini.factory.config.BeanDefinition;
import com.he.SpringMini.factory.support.DefaultListableBeanFactory;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import javafx.beans.binding.ObjectExpression;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/22 12:11 下午
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        // 初始化工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //注册
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService service = (UserService) beanFactory.getBean("userService");
        service.queryUserInfo();

    }
}
