package con.he.SpringMini.beans.factory.support;



import con.he.SpringMini.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singleObejcts = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        return singleObejcts.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singleObejcts.put(beanName, singletonObject);
    }
}
