package con.he.SpringMini.beans.factory.support;


import con.he.SpringMini.beans.BeanException;
import con.he.SpringMini.beans.factory.BeanFactory;
import con.he.SpringMini.beans.factory.config.BeanDefinition;

/**
 * AbstractBeanFactory 继承了父类的 单列bean的获取方法getSingleton。
 * 实现BeanFactory 的getBean的方法。来获取单列。
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeanException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return  null;
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    // 定义 抽象的 方法， 具体实现由子类实现
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;


    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException;
}
