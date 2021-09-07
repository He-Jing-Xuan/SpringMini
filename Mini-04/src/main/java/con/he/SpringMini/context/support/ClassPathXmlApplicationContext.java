package con.he.SpringMini.context.support;

import con.he.SpringMini.beans.BeanException;

import java.util.Map;

/**
 * @Author tal
 * @Date 2021/9/6 11:28 下午
 * @Version 1.0
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    private String[] configLocations;
    public ClassPathXmlApplicationContext() {
    }
    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeanException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeanException {
        this(new String[]{configLocations});
    }
    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeanException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeanException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }



}
