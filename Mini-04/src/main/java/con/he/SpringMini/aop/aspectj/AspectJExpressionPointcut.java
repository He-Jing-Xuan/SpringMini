package con.he.SpringMini.aop.aspectj;

import con.he.SpringMini.aop.ClassFilter;
import con.he.SpringMini.aop.MethodMatcher;
import con.he.SpringMini.aop.Pointcut;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 10:53 上午
 * @Version 1.0
 * 实现ClassFilter， Pointcut,MethodMatcher 接口， 用于处理类和方法的匹配
 * 即： 切点表达式的实现
 */
public class AspectJExpressionPointcut implements ClassFilter, Pointcut, MethodMatcher {

    private static final Set<PointcutPrimitive> SUPPORTED_PRIMITIVES = new HashSet<>();

    static {
        SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }
    // 切入点表达式
    private final PointcutExpression  pointcutExpression;
    public AspectJExpressionPointcut(String expression){
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORTED_PRIMITIVES, this.getClass().getClassLoader());
        pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }

    /**
     * 判断切入点 是否匹配
     * @param clazz
     * @return
     */
    @Override
    public boolean matcher(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
