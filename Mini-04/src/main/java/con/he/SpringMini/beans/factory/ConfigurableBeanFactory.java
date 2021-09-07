package con.he.SpringMini.beans.factory;

import con.he.SpringMini.beans.factory.config.BeanPostProcessor;
import con.he.SpringMini.beans.factory.config.SingletonBeanRegistry;

/**
 * @Author tal
 * @Date 2021/9/6 5:31 下午
 * @Version 1.0
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destrySingletons();

}
