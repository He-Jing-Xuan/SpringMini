package com.he.SpringMini.aop.framework.autoproxy;

import com.he.SpringMini.aop.AdvisedSupport;
import com.he.SpringMini.aop.Advisor;
import com.he.SpringMini.aop.filter.ClassFilter;
import com.he.SpringMini.aop.TargetSource;
import com.he.SpringMini.aop.aspectj.AspectJExpressionPointcutAdvior;
import com.he.SpringMini.aop.framework.ProxyFactory;
import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.PropertyValues;
import com.he.SpringMini.beans.factory.BeanFactory;
import com.he.SpringMini.beans.factory.BeanFactoryAware;
import com.he.SpringMini.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.he.SpringMini.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.reflect.Pointcut;

import java.util.Collection;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 10:58 下午
 * @Version 1.0
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeanException {
       this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeanException {
        if(isInfrastructureClass(beanClass))
            return  null;
        Collection<AspectJExpressionPointcutAdvior> adviors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvior.class).values();
        for(AspectJExpressionPointcutAdvior advior : adviors){
            ClassFilter classFilter = advior.getPointcut().getClassFilter();
            if(!classFilter.matcher(beanClass))
                continue;

            AdvisedSupport advisedSupport = new AdvisedSupport();
            TargetSource targetSource = null;

            try{
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
            }catch (Exception e){
                e.printStackTrace();
            }
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advior.getAdvice());
            advisedSupport.setMethodMatcher(advior.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);
            return new ProxyFactory(advisedSupport);
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeanException {
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeanException {
        return null;
    }

    private boolean isInfrastructureClass(Class<?> beanClass){
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }
}
