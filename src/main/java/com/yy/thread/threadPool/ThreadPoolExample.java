package com.yy.thread.threadPool;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @description: 线程池案例
 * @author: yy
 * @date: 2020/12/24
 */
public class ThreadPoolExample {

    /**
     * FixedThreadPool 也就是固定线程
     */
    public void fixedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorTask(executorService);
    }

    /**
     * 创建一个可缓存的线程池，若线程数超过处理所需，缓存一段时间后会回收，若线程数不够，则新建线程。
     */
    public void cachedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorTask(executorService);
    }


    /**
     * 创建单个线程数的线程池，它可以保证先进先出的执行顺序。
     * @throws InterruptedException
     */
    public void singleThreadExecutor() throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorTask(executorService);

    }

    /**
     * 创建一个可以执行延迟任务的线程池。
     * @throws InterruptedException
     */
    public void scheduledThreadPool()throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        System.out.println("任务添加："+new Date());
        for (int i = 0; i < 4; i++) {
            executorService.schedule(() -> {
                try {
                    System.out.println(String.format("任务被执行，线程：%s,时间：%s", Thread.currentThread().getName(), new Date()));
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, 2, TimeUnit.SECONDS);
        }
        TimeUnit.SECONDS.sleep(10);
        executorService.shutdown();
    }


    /**
     *
     * @throws InterruptedException
     */
    public void threadPoolExecutor() throws InterruptedException {

        /**
         * 1. coreSize: 核心线程数，线程池中始终存活的线程数。
         * 2. maximumPoolSize: 最大线程数，线程池中允许的最大线程数，当线程池的任务队列满了之后可以创建的最大线程数。
         * 3. keepAliveTime: 最大线程数可以存活的时间，当线程中没有任务执行时，最大线程就会销毁一部分，最终保持核心线程数量的线程。
         * 4. unit: 单位是和参数 3 存活时间配合使用的，合在一起用于设定线程的存活时间
         * 5. workQueue: 一个阻塞队列，用来存储线程池等待执行的任务，均为线程安全
         *          LinkedBlockingQueue：一个由链表结构组成的有界阻塞队列
         *
         * 6. threadFactory: 线程工厂，主要用来创建线程，默认为正常优先级、非守护线程
         * 7. handler: 拒绝策略，拒绝处理任务时的策略
         *          AbortPolicy：拒绝并抛出异常。
         *          CallerRunsPolicy：使用当前调用的线程来执行此任务。
         *          DiscardOldestPolicy：抛弃队列头部（最旧）的一个任务，并执行当前任务。
         *          DiscardPolicy：忽略并抛弃当前任务。
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                                                            4,
                                                            100,
                                                            TimeUnit.SECONDS,
                                                            new LinkedBlockingQueue<>(2),
                                                            new ThreadPoolExecutor.DiscardPolicy());


        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(10);
                    System.out.println(index + "线程执行，线程名："+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(50);
        threadPoolExecutor.shutdown();
    }

    private void executorTask(ExecutorService executorService) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("任务被执行，线程：" + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        TimeUnit.SECONDS.sleep(6);
        executorService.shutdown();
    }

}
