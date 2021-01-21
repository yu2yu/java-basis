package com.yy.design.bridge.principle;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/20
 */
public class ConcretImplemention implements ImplementionRole {

    @Override
    public void implemention() {
        System.out.println("具体实现化(Concrete Implementor)角色被访问");
    }
}
