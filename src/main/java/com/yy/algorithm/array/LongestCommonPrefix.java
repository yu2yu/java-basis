package com.yy.algorithm.array;

/**
 * @version 1.0
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 *
 * @author: yy
 * @date: 2020/12/23
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs){

        if(strs.length < 1) return "";
        // 先整体当做 前缀
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if(prefix.length() == 0) return "";
            if (!str.startsWith(prefix)) {
                prefix = prefix.substring(0,str.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flw"};
        System.out.println(longestCommonPrefix(strs));
    }

}
