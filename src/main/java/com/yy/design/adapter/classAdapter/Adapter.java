package com.yy.design.adapter.classAdapter;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/15
 */
public class Adapter extends Source implements Target{

    @Override
    public void preRequest() {
        System.out.println("适配接口中···");
        request();
    }
}
