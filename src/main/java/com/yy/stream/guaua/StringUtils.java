package com.yy.stream.guaua;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @description: 字符串工具
 * @author: yy
 * @date: 2020/12/25
 */
public class StringUtils {

    @Test
    public void testJoin(){
        // jdk
        ImmutableList<String> list = ImmutableList.of("h", "e", "l", "l", "o");
        System.out.println(String.join(",", list));
        // 流
        System.out.println(list.stream().collect(Collectors.joining(",")));

        //
        System.out.println(Joiner.on(",").skipNulls().join("旺财", "汤姆", "杰瑞", null));
        System.out.println(Joiner.on(",").useForNull("空值").join("旺财", "汤姆", "杰瑞", null));
    }

    @Test
    public void testSplit(){

        String s = ",a ,b,,c,";
        Arrays.stream(s.split(",")).forEach(System.out::println);
        System.out.println("=======");
        Splitter.on(",").omitEmptyStrings().trimResults().split(s).forEach(System.out::println);
    }
}
