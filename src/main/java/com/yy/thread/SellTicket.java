package com.yy.thread;

import com.yy.entity.Ticket;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @description: 卖票
 * @author: yy
 * @date: 2020/12/18
 */
public class SellTicket {

    public static void main(String[] args) throws InterruptedException {

        // 资源
        Ticket ticket = new Ticket();

        // 开启10个线程
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    ticket.sell();
                }
            }).start();
        }

        // 主线程
        TimeUnit.SECONDS.sleep(10);
        System.out.println(ticket.getTotal());

    }

}
