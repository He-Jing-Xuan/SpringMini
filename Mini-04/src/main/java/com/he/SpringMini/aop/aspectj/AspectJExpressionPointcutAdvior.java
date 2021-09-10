package com.he.SpringMini.aop.aspectj;

import com.he.SpringMini.aop.Pointcut;
import com.he.SpringMini.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 9:55 下午
 * @Version 1.0
 *  将切面 ，拦截方法，表达式组合到一起
 */
public class AspectJExpressionPointcutAdvior implements PointcutAdvisor {
    //切入点
    private AspectJExpressionPointcut pointcut;
    //具体拦截方法
    private Advice advice;
    // 切入点表达式
    private String expression;

    public void setPointcut(AspectJExpressionPointcut pointcut) {
        this.pointcut = pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression){
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if(pointcut == null){
            // 根据切入点表达式 创建切点
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
