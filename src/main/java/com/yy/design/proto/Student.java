package com.yy.design.proto;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/6
 */
@Data
@ToString
public class Student implements Cloneable{

    private String name;
    private int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
