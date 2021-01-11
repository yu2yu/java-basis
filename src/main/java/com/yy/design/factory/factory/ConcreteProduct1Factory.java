package com.yy.design.factory.factory;

import com.yy.design.factory.entity.ConcreteProduct1;
import com.yy.design.factory.entity.Product;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/11
 */
public class ConcreteProduct1Factory implements ProductFactory{

    @Override
    public Product getProduct() {
        return new ConcreteProduct1();
    }
}
