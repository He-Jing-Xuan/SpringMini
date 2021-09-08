package con.he.SpringMini.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import con.he.SpringMini.beans.BeanException;
import con.he.SpringMini.beans.factory.DisposableBean;
import con.he.SpringMini.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @Author tal
 * @Date 2021/9/7 4:43 下午
 * @Version 1.0
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;
    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestoryMethodName();
    }
    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        // 2. 配置信息 destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeanException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }


    }
}
