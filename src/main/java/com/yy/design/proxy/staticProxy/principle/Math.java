package com.yy.design.proxy.staticProxy.principle;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/14
 */
public class Math implements Subject {
    @Override
    public void show() {
        System.out.println("上课中·····");
    }
}
