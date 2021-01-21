package com.yy.design.bridge;

import com.yy.design.bridge.example.Bag;
import com.yy.design.bridge.example.Color;
import com.yy.design.bridge.example.WalletBag;
import com.yy.design.bridge.example.Yellow;
import com.yy.design.bridge.principle.ConcretImplemention;
import com.yy.design.bridge.principle.ConcreteRole;
import com.yy.design.bridge.principle.ImplementionRole;
import org.junit.Test;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/20
 */
public class BridgeTest {


    @Test
    public void testPrinciple(){
        ImplementionRole implemention = new ConcretImplemention();
        ConcreteRole concreteRole = new ConcreteRole(implemention);
        concreteRole.operate();
    }

    @Test
    public void testExample(){
        Color color = new Yellow("黄色");
        Bag walletBag = new WalletBag(color);
        System.out.println(walletBag.getName());
    }

}
