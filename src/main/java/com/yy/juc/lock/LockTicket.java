package com.yy.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/18
 */
public class LockTicket {

    private int total = 10000;
    Lock lock = new ReentrantLock();

    public int getTotal() {
        return total;
    }

    public void sell(){
        lock.lock();
        try {
            // 非原子操作
            total--;
        }finally {
            lock.unlock();
        }
    }
}
