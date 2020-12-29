package com.yy.algorithm.array;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/29
 */
public class ZTranform {

    public String convert(String s, int numRows){
        if(s.length() < 2 || numRows < 2) return s;
        // 需要z字形转换
        String[] newString = new String[numRows];
        Arrays.fill(newString, "");
        char[] chars = s.toCharArray();
        int len = chars.length;
        int period = (numRows << 1) -2;
        for (int i = 0; i < len; i++) {
            int a = i % period;
            if(a<numRows){
                newString[a] += chars[i];
            }else {
                newString[period-a] += chars[i];
            }
        }
        return String.join("", newString);
    }


    public static void main(String[] args) {
        // LCIRETOESIIGEDHN
        System.out.println(new ZTranform().convert("LEETCODEISHIRING",3));
    }
}
