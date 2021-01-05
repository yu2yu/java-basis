package com.yy.design.factory;

/**
 * @version 1.0
 * @description: 发放奖励接口
 * @author: yy
 * @date: 2021/1/4
 */
public interface PrizeCommodity {

    /**
     * 发放奖励
     * @param req
     * @throws Exception
     */
    void sendCommodity(String req) throws Exception;

}
