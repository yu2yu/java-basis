package com.yy.entity;

/**
 * @version 1.0
 * @description: 票资源
 * @author: yy
 * @date: 2020/12/18
 */
public class Ticket {

    private int total = 10000;
    final Object o = new Object();

    public int getTotal() {
        return total;
    }

    public void sell(){
        // 非原子操作
        synchronized (o) {
            total--;
        }
    }

}
