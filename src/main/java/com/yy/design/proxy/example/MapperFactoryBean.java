package com.yy.design.proxy.example;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 动态代理
 * @author: yy
 * @date: 2021/1/14
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {


    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{mapperInterface},
                (proxy, method, args) -> {
                    // 需要替换
                    Select annotation = method.getAnnotation(Select.class);
                    String sql = annotation.value().replace("#{userId}", args[0].toString());
                    System.out.println(sql);
                    // 返回查询结果
                    return "success";
                }
        );
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
