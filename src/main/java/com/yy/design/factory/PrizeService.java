package com.yy.design.factory;

/**
 * @version 1.0
 * @description: 奖励模式
 * @author: yy
 * @date: 2021/1/4
 */
public class PrizeService {

    public String awardToUser(String req) {
        //有三种奖励用户方式
        if("1".equals(req)){
            // 1优惠券
        }else if("2".equals(req)){
            // 2实物商品
        }else if("3".equals(req)){
            // 3第三方兑换卡(爱奇艺)
        }
        return null;
    }

    // 工厂模式优化代码


}
