package com.he.SpringMini.beans.factory;

import com.he.SpringMini.beans.factory.config.BeanPostProcessor;
import com.he.SpringMini.beans.factory.config.SingletonBeanRegistry;
import com.he.SpringMini.util.StringValueResolver;

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

    /**
     * Add a String resolver for embedded values such as annotation attributes.
     * @param valueResolver the String resolver to apply to embedded values
     * @since 3.0
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * Resolve the given embedded value, e.g. an annotation attribute.
     * @param value the value to resolve
     * @return the resolved value (may be the original value as-is)
     * @since 3.0
     */
    String resolveEmbeddedValue(String value);

}
