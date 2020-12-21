package com.yy.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/18
 */
public class AtomicTicket {

    private AtomicInteger ticket = new AtomicInteger(10000);

    public int getTicket() {
        return ticket.get();
    }

    public void sell(){
        ticket.decrementAndGet();
    }

}
