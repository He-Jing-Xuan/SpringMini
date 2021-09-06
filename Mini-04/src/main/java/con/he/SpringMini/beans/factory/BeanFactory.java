package con.he.SpringMini.beans.factory;


import con.he.SpringMini.beans.BeanException;

public interface BeanFactory {
    /**
     * 无参构造
     *
     * @param name
     * @return
     * @throws BeanException
     */
    Object getBean(String name) throws BeanException;

    /**
     * 有参构造
     *
     * @param name
     * @param args
     * @return
     * @throws BeanException
     */
    Object getBean(String name, Object... args) throws BeanException;

    <T> T getBean(String name,Class<T> requiredType);
}
