package com.he.SpringMini.aop;

import com.he.SpringMini.aop.filter.Pointcut;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 10:01 下午
 * @Version 1.0
 */
public interface PointcutAdvisor extends Advisor {
    /**
     * 获取切入点
     * @return
     */
    Pointcut getPointcut();
}
