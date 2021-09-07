package con.he.SpringMini.context;

import con.he.SpringMini.beans.BeanException;

/**
 * @Author tal
 * @Date 2021/9/6 9:31 下午
 * @Version 1.0
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     * @throws BeanException
     */
    void refresh() throws BeanException;
}
