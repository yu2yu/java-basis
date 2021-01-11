package com.yy.design.factory.type;

import com.yy.design.factory.entity.ConcreteProduct1;
import com.yy.design.factory.entity.ConcreteProduct2;
import com.yy.design.factory.entity.Product;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/11
 */
public class SimpleFactory {

    public static void main(String[] args) {
        Product product = SimpleFactory.getProduct(1);
        product.show();
    }

    final class Const {
        static final int PRODUCT_A = 0;
        static final int PRODUCT_B = 1;
        static final int PRODUCT_C = 2;
    }

    public static Product getProduct(int type){
        switch (type){
            case Const.PRODUCT_A:
                return new ConcreteProduct1();
            case Const.PRODUCT_B:
                return new ConcreteProduct2();
            default:
        }
        return null;
    }

}
