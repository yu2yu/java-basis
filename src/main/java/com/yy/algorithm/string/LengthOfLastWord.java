package com.yy.algorithm.string;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/13
 */
public class LengthOfLastWord {


    public int lengthOfLastWord(String s){
        String[] strArr = s.split(" ");
        if (strArr.length < 1) return 0;
        return strArr[strArr.length-1].length();
    }


    public int lengthOfLastWord2(String s){
        s = s.trim();
        int start = s.lastIndexOf(" ")+1;
        return s.substring(start).length();
    }


    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord(" a"));
    }

}
