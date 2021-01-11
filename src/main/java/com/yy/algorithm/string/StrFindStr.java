package com.yy.algorithm.string;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/8
 */
public class StrFindStr {

    public int strStr(String str,String subStr){
        int length = str.length(),count=0,subLength = subStr.length();
        for (int i = 0; i < length-subLength+1; i++) {
            if(str.charAt(i) == subStr.charAt(count)){
                count++;
                if(count == subLength) return i-subLength+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrFindStr().strStr("hello", "ll"));
        System.out.println(new StrFindStr().strStr("aaaaa", "bba"));
        System.out.println(new StrFindStr().strStr("aaaaa", "a"));
    }

}
