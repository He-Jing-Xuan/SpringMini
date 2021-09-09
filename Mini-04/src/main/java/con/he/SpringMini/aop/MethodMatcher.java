package con.he.SpringMini.aop;

import java.lang.reflect.Method;

/**
 * @Author tal
 * @Date 2021/9/9 10:54 上午
 * @Version 1.0
 */
public interface MethodMatcher {
    /**
     * 找到表达范围内 匹配下的目标类和方法
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method, Class<?> targetClass);

}
