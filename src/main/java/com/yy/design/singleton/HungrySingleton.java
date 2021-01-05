package com.yy.design.singleton;

import org.junit.Test;

/**
 * @description: 饿汉式单例
 * @author: yy
 * @date: 2021/1/5
 */
public class HungrySingleton {

    private static HungrySingleton singleton = null;

    // 私有性，以防创建
    private HungrySingleton(){
    }

    public static HungrySingleton getInstance(){
        if(singleton == null){
            singleton = new HungrySingleton();
        }
        return singleton;
    }
}
