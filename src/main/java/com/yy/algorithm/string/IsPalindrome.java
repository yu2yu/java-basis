package com.yy.algorithm.string;

/**
 * @description: 回文串 正读和反读都是一样的字符串
 * @author: yy
 * @date: 2021/1/12
 */
public class IsPalindrome {

    public boolean isPalindrome(String str){
        // 去掉空格以及其他非英文字符
        str = str.replaceAll("[^a-zA-Z0-9]*", "").toLowerCase();
        int left = 0,right=str.length()-1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(String str){
        // 去掉空格以及其他非英文字符
        str = str.toLowerCase();
        int left = 0,right=str.length()-1;
        while(left<right){
            if (!Character.isDigit(str.charAt(left)) && !Character.isLowerCase(str.charAt(left)) ) {
                left++;
                continue;
            }
            if (!Character.isDigit(str.charAt(right)) && !Character.isLowerCase(str.charAt(right))) {
                right--;
                continue;
            }
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome2("A man, a plan, a canal: Panama"));
        System.out.println(new IsPalindrome().isPalindrome2(""));
        System.out.println(new IsPalindrome().isPalindrome2("race a car"));
    }
}
