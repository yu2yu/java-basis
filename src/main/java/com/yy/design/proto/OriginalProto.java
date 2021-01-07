package com.yy.design.proto;

import org.junit.Test;

/**
 * @description: 原型模式
 * @author: yy
 * @date: 2021/1/6
 */
public class OriginalProto {

    @Test
    public void testProto() throws CloneNotSupportedException {
        // 测试原型模式
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(21);
        System.out.println(student.toString());
        Student clone = (Student)student.clone();
        System.out.println(clone.toString());
        System.out.println(student == clone);
    }
}
