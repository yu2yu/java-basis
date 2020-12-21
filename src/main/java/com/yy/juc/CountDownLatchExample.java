package com.yy.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @description: CountDownLatch例子
 * @author: yy
 * @date: 2020/12/21
 */
public class CountDownLatchExample {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "启动");
                    TimeUnit.SECONDS.sleep(10);
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },i+"").start();
        }

        System.out.println("主线程等待中");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完成");


    }

}
