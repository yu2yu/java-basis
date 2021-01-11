package com.yy.design.factory.type;

import com.yy.design.factory.entity.Product;
import com.yy.design.factory.factory.ProductFactory;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/11
 */
public class FactoryMethod {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.yy.design.factory.factory.ConcreteProduct1Factory");
        ProductFactory productFactory = (ProductFactory) aClass.newInstance();
        Product product = productFactory.getProduct();
        product.show();
    }
}
