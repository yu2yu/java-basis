package com.yy.algorithm.string;

import org.checkerframework.checker.units.qual.A;

/**
 * @description: 旋转字符串
 * @author: yy
 * @date: 2021/1/13
 */
public class RotateString {

    public boolean rotateString(String A, String B) {
        // 总共旋转A的大小
        if(A.equals(B)) return true;
        int len = A.length();
        for (int i = 0; i < len; i++) {
            // 怎么旋转？
            String substring = A.substring(1, len);
            A = substring+A.charAt(0);
            if(A.equals(B)){
                return true;
            }
        }
        return false;
    }

    public boolean rotateString2(String A, String B) {
        // 如何判断B是A+A的子串
        return A.length()==B.length() && (A+A).contains(B);
    }

    public boolean rotateString3(String A, String B) {
        // 如何判断B是A+A的子串
        int N = A.length();
        if (N != B.length()) return false;
        if (N == 0) return true;
        return judgeSubStr(A+A,B);
    }

    // KMP
    public boolean judgeSubStr(String str,String subStr){
        KMP kmp = new KMP(subStr);
        int match = kmp.strMatch(str + str);
        if(match != -1) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString3("abcde", "cdeab"));
        System.out.println(new RotateString().rotateString3("abcde", "abced"));
        System.out.println(new RotateString().rotateString3("", ""));
    }


}
