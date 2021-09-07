package con.he.SpringMini.beans.factory.config;

/**
 * @Author tal
 * @Date 2021/9/6 9:17 下午
 * @Version 1.0
 *
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDifinition加载完成之后，实例化Bean对象之前， 提供修改BeanDefinition的功能
     * @param beanFactory
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
}
