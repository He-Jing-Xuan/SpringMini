import con.he.SpringMini.beans.factory.*;
import con.he.SpringMini.context.ApplicationContext;
import con.he.SpringMini.context.ApplicationContextAware;

/**
 * @Author tal
 * @Date 2021/9/6 5:16 下午
 * @Version 1.0
 */
public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {
    private String uId;
    private String location;
    private String company;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    private IUUserDao userDao;

    public UserService(String uId, IUUserDao userDao) {
        this.uId = uId;
        this.userDao = userDao;
    }
    public UserService(){}
    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public IUUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUUserDao userDao) {
        this.userDao = userDao;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    @Override
    public void setBeanName(String name) {

    }
}
