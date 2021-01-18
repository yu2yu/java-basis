package com.yy.thread.threadPool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @description: 线程池的队列
 * @author: yy
 * @date: 2021/1/18
 */
public class QueueExample {


    @Test
    public void testArrayBlock() throws InterruptedException {
        // 基于数组的有界队列
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
        for (int i = 0; i < 10; i++) {
            blockingQueue.put(i);
            System.out.println("插入"+i+"成功");
        }
    }


    @Test
    public void testLinkBlock() throws InterruptedException {
        // 基于链表的有界队列
        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>(5);
        for (int i = 0; i < 10; i++) {
            linkedBlockingDeque.put(i);
            System.out.println("插入"+i+"成功");
        }
    }


    @Test
    public void testLink() throws InterruptedException {
        // 基于链表的无界队列
        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();
        for (int i = 0; i < 10; i++) {
            linkedBlockingDeque.put(i);
            System.out.println("插入"+i+"成功");
        }
    }
}
