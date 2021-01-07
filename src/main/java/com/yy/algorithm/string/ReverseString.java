package com.yy.algorithm.string;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/7
 */
public class ReverseString {

    public void reverseString(char[] s){
        int size = s.length;
        for (int i = 0; i < size/2; i++) {
            if(s[i] == s[size-1-i]){
                continue;
            }
            char temp = s[i];
            s[i] = s[size-1-i];
            s[size-1-i] = temp;
        }
    }

    public void reverseString2(char[] s){
        for (int i = 0; i < s.length/2; i++) {
            if(s[i] == s[s.length-1-i]){
                continue;
            }
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }

    public void reverseString3(char[] s){
        int left = 0;
        int right = s.length - 1;
        while(left<right){
            if(s[left] == s[right]){
                continue;
            }
            char temp = s[left];
            s[left++] = s[right-left];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        new ReverseString().reverseString(new char[]{'h','e','l','l','o'});
        System.out.println();
        new ReverseString().reverseString(new char[]{'H','a','n','n','a','h'});
    }

}
