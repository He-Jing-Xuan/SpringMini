import com.he.SpringMini.aop.AdvisedSupport;
import com.he.SpringMini.aop.TargetSource;
import com.he.SpringMini.aop.aspectj.AspectJExpressionPointcut;
import com.he.SpringMini.aop.framework.CglibToAopProxy;
import com.he.SpringMini.aop.framework.JdkDynamicAopProxy;
import com.he.SpringMini.beans.factory.support.DefaultListableBeanFactory;
import com.he.SpringMini.beans.factory.xml.XmlBeanDefinitionReader;
import com.he.SpringMini.context.support.ClassPathXmlApplicationContext;

/**
 * @Author tal
 * @Date 2021/9/6 5:21 下午
 * @Version 1.0
 */
public class Test {


    public static void main(String[] args) {
        //初始化工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 读取配置问价和注册bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring1.xml");
        UserService service = (UserService) beanFactory.getBean("userService");
        service.queryUserInfo();
    }
    @org.junit.Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring1.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        //System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }
    @org.junit.Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring1.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
    @org.junit.Test
    public void test_dynamic(){
        IUUserDao user = new User();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        // 设计目标对象
        advisedSupport.setTargetSource(new TargetSource(user));
        // 设置拦截器
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        // 设计切入点
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* IUUserDao.*(..))"));
        //  获取代理对象
        IUUserDao user1 = (IUUserDao) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果："+user1.queryUserName("cc"));

        // 代理对象(Cglib2AopProxy)
        IUUserDao proxy_cglib = (IUUserDao) new CglibToAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));


    }
    @org.junit.Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring2.xml");
        IUUserDao userService = applicationContext.getBean("user", User.class);
        System.out.println("测试结果：" + userService.queryUserName("ff"));
    }




}
