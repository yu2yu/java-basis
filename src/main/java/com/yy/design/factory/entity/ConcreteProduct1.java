package com.yy.design.factory.entity;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/11
 */
public class ConcreteProduct1 implements Product{

    @Override
    public void show() {
        System.out.println("具体产品1显示......");
    }
}
