package com.he.SpringMini.context;

import com.he.SpringMini.beans.factory.ListabelBeanFactory;

/**
 * @Author tal
 * @Date 2021/9/6 9:29 下午
 * @Version 1.0
 *上下文
 * 该接口继承了 ListabelBeanFactory ， 获得了BeanFactory的一系列的方法
 * 顶层接口继承 ApplicationEventPublisher 使得容器具备了事件的发布能力
 */
public interface ApplicationContext extends ListabelBeanFactory ,ApplicationEventPublisher{
}
