package com.he.SpringMini.context.annotation;

import cn.hutool.core.util.StrUtil;
import com.he.SpringMini.beans.factory.config.BeanDefinition;
import com.he.SpringMini.beans.factory.support.BeanDefinitionRegistry;
import com.he.SpringMini.stereotype.Component;

import java.util.Set;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/10 11:02 上午
 * @Version 1.0
 */
public class ClassPathBeanDefinitionScanner extends ClassPathSacnningCandidateComponentProvider{
    private BeanDefinitionRegistry registry;
    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry){
        this.registry = registry;
    }
    public void doScan(String... basePackages){
        // 遍历 包路径 下的 bean
        for(String basePackage : basePackages){
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for(BeanDefinition beanDefinition : candidates){
                String beanScpe =  resolveBeanScope(beanDefinition);
                if(StrUtil.isNotEmpty(beanScpe)){
                    beanDefinition.setScope(beanScpe);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition),beanDefinition);
            }
        }
    }
    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) return scope.value();
        return StrUtil.EMPTY;
    }
    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        // Component注解是否赋值，  如果赋值  就 使用value作为beanName；
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }


}
