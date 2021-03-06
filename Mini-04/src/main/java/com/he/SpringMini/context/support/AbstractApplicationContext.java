package com.he.SpringMini.context.support;

import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.factory.config.BeanFactoryPostProcessor;
import com.he.SpringMini.beans.factory.config.BeanPostProcessor;
import com.he.SpringMini.beans.factory.config.ConfigurableListableBeanFactory;
import com.he.SpringMini.context.ApplicationEvent;
import com.he.SpringMini.context.ApplicationListener;
import com.he.SpringMini.context.ConfigurableApplicationContext;
import com.he.SpringMini.context.event.ApplicationEventMulticaster;
import com.he.SpringMini.context.event.ContextClosedEvent;
import com.he.SpringMini.context.event.ContextRefreshedEvent;
import com.he.SpringMini.context.event.SimpleApplicationEventMuticaster;
import com.he.SpringMini.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @Author tal
 * @Date 2021/9/6 9:33 下午
 * @Version 1.0
 * 继承了 DefaultResourceLoader 使得拥有了 资源加载的能力，
 * 实现了 ConfigurableApplicationContext 就拥有了 刷新容器的能力
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeanException {
        // 创建beanFactory
        refreshBeanFactory();
        // 获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        //添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 在bean实例化之前，执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);
        // BeanPostProstcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        //初始化事件的发布者
        initApplicationEventMulticaster();
        // 注册事件监听器
        registerListeners();
        //提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
        //  发布一个 容器刷新完成的事件，
        finishRefresh();

    }


    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        //发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));
        getBeanFactory().destrySingletons();
    }

    /**
     * 创建bean工厂
     * 加载配置文件
     * @throws BeanException
     */
    protected abstract void refreshBeanFactory() throws BeanException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){
      Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
      for(BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()){
          beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
      }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String,BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String name) throws BeanException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return getBeanFactory().getBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return getBeanFactory().getBean(name,requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeanException {
        return getBeanFactory().getBean(requiredType);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 初始化事件的发布者
     * 将发布者的bean对象注入到 beanFactory中
     */
    private void initApplicationEventMulticaster(){
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMuticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME,applicationEventMulticaster);
    }

    /**
     * 给事件的发布者添加 监听者
     */
    private void registerListeners(){
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for(ApplicationListener listener : applicationListeners){
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }
    private void finishRefresh(){
        publishEvent(new ContextRefreshedEvent(this));
    }
}
