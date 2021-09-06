package con.he.SpringMini.beans.factory.support;


import con.he.SpringMini.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    BeanDefinition registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
    boolean containsBeanDefinition(String  beanName);
}
