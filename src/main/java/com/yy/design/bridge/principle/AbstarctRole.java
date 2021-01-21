package com.yy.design.bridge.principle;

/**
 * @description: 抽象化角色
 * @author: yy
 * @date: 2021/1/20
 */
public abstract class AbstarctRole {

    // 使用组合模式来替代继承的繁杂冗余性
    protected ImplementionRole implementionRole;

    protected AbstarctRole(ImplementionRole implementionRole) {
        this.implementionRole = implementionRole;
    }

    public abstract void operate();

}
