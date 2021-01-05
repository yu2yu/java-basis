package com.yy.design.singleton;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/5
 */
public class TestSingle {

    @Test
    public void testSingleton() throws InterruptedException {

        // 多线程创建
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                HungrySingleton instance1 = HungrySingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + ":" + instance1);
            },String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(3);
        System.out.println("final");

    }

    @Test
    public void testSingletonSynchronized() throws InterruptedException {

        // 多线程创建
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                HungrySingletonSynchronized instance1 = HungrySingletonSynchronized.getInstance();
                System.out.println(Thread.currentThread().getName() + ":" + instance1);
            },String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(3);
        System.out.println("final");

    }

}
