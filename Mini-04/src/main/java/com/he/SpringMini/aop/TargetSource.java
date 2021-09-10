package com.he.SpringMini.aop;

/**
 * @Author tal
 * @Date 2021/9/9 10:54 上午
 * @Version 1.0
 */
public class TargetSource {
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget(){
        return this.target;
    }

}
