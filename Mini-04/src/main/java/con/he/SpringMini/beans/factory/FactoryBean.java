package con.he.SpringMini.beans.factory;

/**
 * @Author tal
 * @Date 2021/9/8 10:51 上午
 * @Version 1.0
 */
public interface FactoryBean <T>{
    //获取对象
    T getObject() throws Exception;
    //获取对象类型
    Class<?> getObjectType();
    //判断是否是单列。
    boolean isSingleton();
}
