import com.he.SpringMini.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 11:19 下午
 * @Version 1.0
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}
