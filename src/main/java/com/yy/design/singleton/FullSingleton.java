package com.yy.design.singleton;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/5
 */
public class FullSingleton {

    private static final FullSingleton singleton = new FullSingleton();

    private FullSingleton(){

    }

    public static FullSingleton getInstance(){
        return singleton;
    }

}
