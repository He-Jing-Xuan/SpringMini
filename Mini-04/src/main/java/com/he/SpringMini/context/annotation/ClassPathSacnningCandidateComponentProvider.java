package com.he.SpringMini.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.he.SpringMini.beans.factory.config.BeanDefinition;
import com.he.SpringMini.stereotype.Component;

import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/10 10:56 上午
 * @Version 1.0
 * 对象扫描装配
 */
public class ClassPathSacnningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String bassPackage){
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        // 获取到 加了注解的类
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(bassPackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;

    }
}
