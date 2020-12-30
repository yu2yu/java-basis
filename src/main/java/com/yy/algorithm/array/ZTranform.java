package com.yy.algorithm.array;

import com.google.common.collect.Lists;

import java.util.ArrayList;
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
        int len = s.length();
        int period = (numRows << 1) -2;
        for (int i = 0; i < len; i++) {
            int a = i % period;
            if(a<numRows){
                newString[a] += s.charAt(i);
            }else {
                newString[period-a] += s.charAt(i);
            }
        }
        return String.join("", newString);
    }

    public String convertTwo(String s, int numRows){
        if(numRows < 2) return s;
        ArrayList<StringBuilder> builders = new ArrayList<>();
        for(int i = 0; i < numRows; i++) builders.add(new StringBuilder());
        int i=0,flag = -1;
        for (char c : s.toCharArray()) {
            builders.get(i).append(c);
            if(i==numRows-1 || i==0) flag = -flag;
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : builders) res.append(row);
        return res.toString();
    }


    public String convertThree(String s, int numRows){
        if(numRows < 2) return s;
        String[] newString = new String[numRows];
        Arrays.fill(newString, "");
        int i=0,flag = -1;
        for (char c : s.toCharArray()) {
            newString[i]+=c;
            if(i==numRows-1 || i==0) flag = -flag;
            i+=flag;
        }
        return String.join("", newString);
    }

    public static void main(String[] args) {
        // LCIRETOESIIGEDHN
        System.out.println(new ZTranform().convertTwo("LEETCODEISHIRING",3));
    }
}
