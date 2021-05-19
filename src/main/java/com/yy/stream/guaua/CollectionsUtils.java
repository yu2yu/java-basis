package com.yy.stream.guaua;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @description: guaua集合工具
 * @author: yy
 * @date: 2020/12/25
 */
public class CollectionsUtils {


    /**
     * 集合的创建
     */
    @Test
    public void collectionCreate(){
        // shit
        HashMap<String, Map<Long, List<String>>> stringMapHashMap = new HashMap<String, Map<Long, List<String>>>();

        HashMap<String, Map<Long, List<String>>> map = Maps.newHashMap();
        ArrayList<Object> lists = Lists.newArrayList();
    }


    /**
     * 集合操作
     */
    @Test
    public void collectionoperate(){
        // shit
        List list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        //
        ArrayList<String> arrayList = Lists.newArrayList("a", "b", "c", "d");
        //
        ImmutableMap<String, String> map = ImmutableMap.of("k1", "v1", "k2", "v2");
    }

    /**
     * 不可变集合
     */
    @Test
    public void immutableSetTest(){
        ImmutableList<Integer> immutableList = ImmutableList.of(1, 2, 3, 4, 5);
        immutableList.add(7);
        immutableList.reverse();
    }

    @Test
    public void hashMultiSet(){
        ArrayList<String> arrayList = Lists.newArrayList("a", "b", "c", "d","a","c","a");
        HashMultiset<String> multiset = HashMultiset.create(arrayList);
        multiset.elementSet().stream().forEach(s -> System.out.println(s+":" + multiset.count(s)));
    }

    @Test
    public void hashMultiMap(){
        HashMultimap<String,String> hashMultimap = HashMultimap.create();
        hashMultimap.put("狗","andy");
        hashMultimap.put("狗","liSi");
        hashMultimap.put("猫","hello");
        hashMultimap.put("猫","hi");
        System.out.println(hashMultimap.get("狗"));
    }


}
