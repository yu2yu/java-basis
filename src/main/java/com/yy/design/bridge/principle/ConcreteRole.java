package com.yy.design.bridge.principle;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/20
 */
public class ConcreteRole extends AbstarctRole{

    public ConcreteRole(ImplementionRole implementionRole) {
        super(implementionRole);
    }

    @Override
    public void operate() {
        implementionRole.implemention();
        System.out.println("具体实现化(Concrete AbstarctRole)角色被访问");
    }
}
