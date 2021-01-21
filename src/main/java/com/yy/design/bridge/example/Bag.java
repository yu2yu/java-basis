package com.yy.design.bridge.example;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/20
 */
public abstract class Bag {

    protected Color color;

    public Bag(Color color) {
        this.color = color;
    }

    public abstract String getName();
}
