package com.yy.design.bridge.example;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/20
 */
public class GucciBag extends Bag{

    public GucciBag(Color color) {
        super(color);
    }

    @Override
    public String getName() {
        return "gucci " + color.name;
    }
}
