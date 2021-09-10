package com.he.SpringMini.aop.framework;

import com.he.SpringMini.aop.AdvisedSupport;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 9:59 下午
 * @Version 1.0
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;
    public ProxyFactory(AdvisedSupport advisedSupport){
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return creatAopProxy().getProxy();
    }

    /**
     * 选择是基于Cglib还是JDK来代理
     * @return
     */
    private AopProxy creatAopProxy(){
        if(advisedSupport.isProxyTargetClass()){
            return new CglibToAopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
