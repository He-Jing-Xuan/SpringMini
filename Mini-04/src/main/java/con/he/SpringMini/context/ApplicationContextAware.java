package con.he.SpringMini.context;

import con.he.SpringMini.beans.BeanException;
import con.he.SpringMini.beans.factory.Aware;

/**
 * @Author tal
 * @Date 2021/9/8 9:46 上午
 * @Version 1.0
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeanException;
}
