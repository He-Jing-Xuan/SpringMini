package com.he.SpringMini.beans.factory.support;



import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.factory.DisposableBean;
import com.he.SpringMini.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singleObejcts = new HashMap<>();
    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();
    protected static final Object NULL_OBJECT = new Object();
    @Override
    public Object getSingleton(String beanName) {
        return singleObejcts.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singleObejcts.put(beanName, singletonObject);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singleObejcts.put(beanName, singletonObject);
    }

    /**
     *  用户注册实现了 DisposableBean 接口的bean对象
     * @param beanName
     * @param bean
     */
    public void registerDisposableBean(String beanName,DisposableBean bean){
        disposableBeans.put(beanName,bean);
    }

    public void destroySingletons(){
        Set<String> ketSet = this.disposableBeans.keySet();
        Object [] disposableBeanNames = ketSet.toArray();

        for(int i= disposableBeanNames.length-1;i>=0;i--){
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try{
                disposableBean.destroy();
            }catch (Exception e){
                throw new BeanException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

    /**
     * 销毁 实现了  disposableBean 接口的单例。
     * 实现 ConfigurableBeanFactory 接口定义的 destroySingletons 方法
     * 可以看到 DefaultSingletonBeanRegistry 并没有实现ConfigurableBeanFactory，
     * 而是由子类AbstractBeanFactory实现。
     * AbstractBeanFactory把实现接口的操作又交给继承的父类处理。所以这块还是蛮有意思的，是一种不错的隔离分层服务的设计方式
     */
    public void destrySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();
        for(int i = disposableBeanNames.length -1 ;i>=0 ;i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);

            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeanException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }

    }
}
