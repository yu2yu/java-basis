package com.yy.design.singleton;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/5
 */
public class HungrySingletonSynchronized {

    private static volatile HungrySingletonSynchronized singleton = null;

    // 私有性，以防创建
    private HungrySingletonSynchronized(){
    }

    public static synchronized HungrySingletonSynchronized getInstance(){
        if(singleton == null){
            synchronized (HungrySingletonSynchronized.class) {
                if(singleton == null) {
                    singleton = new HungrySingletonSynchronized();
                }
            }
        }
        return singleton;
    }
}
