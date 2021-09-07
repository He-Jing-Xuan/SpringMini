package con.he.SpringMini.beans.factory.support;



import con.he.SpringMini.beans.BeanException;
import con.he.SpringMini.beans.PropertyValue;
import con.he.SpringMini.beans.PropertyValues;
import con.he.SpringMini.beans.factory.config.AutowireCapableBeanFactory;
import con.he.SpringMini.beans.factory.config.BeanDefinition;
import con.he.SpringMini.beans.factory.config.BeanPostProcessor;
import con.he.SpringMini.beans.factory.config.BeanReference;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Constructor;

/**
 * 创建bean  并加入到缓存中
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            System.out.println(bean);
            //填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            //bean的初始化和前置与后置方法的处理
            bean = initializeBean(beanName,bean,beanDefinition);
        } catch (Exception e) {
            throw new BeanException("Instantiation of bean failed", e);
        }
        // 加入到缓存中
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 拿到bean 定义的构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            // 参数比较 这里是简化版  实际上需要比较：入参类型，否则相同数量不同入参类型的情况
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }
        // 创建bean
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
    }

    /**
     * 填充对象属性
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtils.setProperty(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeanException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition){
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean,beanName);

        // 待完成内容：invokeInitMethbods(beanName, wrappedBean, beanDefinition);
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;

    }
    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {
        // 待完成内容：invokeInitMethbods(beanName, wrappedBean, beanDefinition);
        //invokeInitMethods(beanName, wrappedBean, beanDefinition);

    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeanException {
       Object result = existingBean ;
       for(BeanPostProcessor processor : getBeanPostProcessors() ){
           Object current = processor.postProcessBeforeInitialization(result,beanName);
           if(current == null) return result;
           result = current;
       }
       return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeanException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;

    }
}
