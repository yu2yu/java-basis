package com.yy.design.factory.factory;

import com.yy.design.factory.entity.ConcreteProduct2;
import com.yy.design.factory.entity.Product;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/11
 */
public class ConcreteProduct2Factory implements ProductFactory {

    @Override
    public Product getProduct() {
        return new ConcreteProduct2();
    }
}
