package com.yy.design.proxy.staticProxy.principle;

import org.junit.Test;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/14
 */
public class ProxyMath implements Subject {

    private Subject subject;

    public ProxyMath(Subject subject) {
        this.subject = subject;
    }

    public void preShow(){
        System.out.println("上课之前，需要准备教案·····");
    }

    public void afterShow(){
        System.out.println("上课之后，需要准备课后作业·····");
    }

    @Override
    public void show() {
        preShow();
        subject.show();
        afterShow();
    }
}
