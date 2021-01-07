package com.yy.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/7
 */
public class FirstUniqChar {


    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        // 找到它的第一个不重复的字符，并返回它的索引
        for (int i = 0; i < chars.length; i++) {
            boolean flag = true;
            for (int j = 0; j < chars.length; j++) {
                if(i!=j && chars[i] == chars[j]){
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        // 怎么空间换时间呢？
        int[] arr = new int[26];
        int size = s.length();
        // 找到它的第一个不重复的字符，并返回它的索引
        for (int i = 0; i < size; i++) {
            arr[s.charAt(i)-'a']++ ;
        }
        for (int i = 0; i < size; i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        // 怎么空间换时间呢？
        Map<Character, Integer> map = new HashMap<>();
        int size = s.length();
        // 找到它的第一个不重复的字符，并返回它的索引
        for (int i = 0; i < size; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int i = 0; i < size; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar3("leetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar3("loveleetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar3("aadadaad"));
        System.out.println(new FirstUniqChar().firstUniqChar3("z"));
    }
}
