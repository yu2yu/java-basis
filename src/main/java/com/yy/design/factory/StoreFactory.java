package com.yy.design.factory;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2021/1/4
 */
public class StoreFactory {

    public PrizeCommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponService();
//        if (2 == commodityType) return new GoodsCommodityService();
//        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
