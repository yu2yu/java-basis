package com.yy.design.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/14
 */
public class ProxyCglib implements MethodInterceptor {

    private Object target;

    public ProxyCglib(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        // 1. 工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类
        return enhancer.create();
    }

    public void preShow(){
        System.out.println("上课之前，需要准备教案·····");
    }

    public void afterShow(){
        System.out.println("上课之后，需要准备课后作业·····");
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        preShow();
        Object invoke = method.invoke(target, objects);
        afterShow();
        return invoke;
    }
}
