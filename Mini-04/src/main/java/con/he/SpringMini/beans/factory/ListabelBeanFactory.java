package con.he.SpringMini.beans.factory;

import con.he.SpringMini.beans.BeanException;

/**
 * @Author tal
 * @Date 2021/9/6 5:26 下午
 * @Version 1.0
 */
public interface ListabelBeanFactory extends BeanFactory {
    <T> T getBeansOfType(Class<T> type);
    String getBeansDefinitionNames();
}
