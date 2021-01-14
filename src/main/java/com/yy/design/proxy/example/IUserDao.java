package com.yy.design.proxy.example;

import org.springframework.stereotype.Component;

/**
 * @description: 需要代理的类
 * @author: yy
 * @date: 2021/1/14
 */
public interface IUserDao {

    @Select("select userName from user where id = #{userId}")
    String query(String userId);

}
