package com.yy.design.bridge.example;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/20
 */
public class WalletBag extends Bag{

    public WalletBag(Color color) {
        super(color);
    }

    @Override
    public String getName() {
        return "钱包 " + color.name;
    }
}
