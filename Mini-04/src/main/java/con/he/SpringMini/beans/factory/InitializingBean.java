package con.he.SpringMini.beans.factory;

/**
 * @Author tal
 * @Date 2021/9/7 4:43 下午
 * @Version 1.0
 */
public interface InitializingBean {
    /**
     * bean的初始化，在加载配置文件之后。
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
