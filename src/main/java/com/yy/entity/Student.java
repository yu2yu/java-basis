package com.yy.entity;

import com.google.common.collect.Comparators;
import com.google.common.collect.ComparisonChain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>{

    private String name;
    private Integer age;

    private Person person;

    @Override
    public int compareTo(Student o) {
        // 先对比age
//        int i = this.age.compareTo(o.getAge());
//        if(i == 0){
//            // 再对比name
//            i = this.getName().compareTo(o.getName());
//        }
//        return i;

        return ComparisonChain.start()
                .compare(this.age,o.getAge())
                .compare(this.getName(),o.getName())
                .result();

    }
}
