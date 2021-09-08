import con.he.SpringMini.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author tal
 * @Date 2021/9/8 2:01 下午
 * @Version 1.0
 */
public class ProxyBeanFactory implements FactoryBean<IUUserDao> {
    @Override
    public IUUserDao getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "小贺");
            hashMap.put("10002", "嘻嘻");
            hashMap.put("10003", "嘿嘿");
            return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
        };
        return (IUUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{IUUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
