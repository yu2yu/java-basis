package com.yy.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 动态代理
 * @author: yy
 * @date: 2021/1/14
 */
public class ProxyMathDynamic {

    private Object target;

    public ProxyMathDynamic(Object target) {
        this.target = target;
    }

    public void preShow(){
        System.out.println("上课之前，需要准备教案·····");
    }

    public void afterShow(){
        System.out.println("上课之后，需要准备课后作业·····");
    }


    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    preShow();
                    Object returnValue = method.invoke(target, args);
                    afterShow();
                    return returnValue;
                }
        );
    }
}
