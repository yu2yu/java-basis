package com.yy.algorithm.string;

/**
 * @description: KMP算法
 * @author: yy
 * @date: 2021/1/12
 */
public class KMP {


    /**
     * 暴力解法
     * @param source
     * @param target
     * @return
     */
    public int strMatch(String source,String target){
        int len = source.length(),sunLen = target.length();
        for (int i = 0; i < len-sunLen; i++) {
            int temp = 0;
            for (int i1 = 0; i1 < sunLen; i1++) {
                if(source.charAt(i+temp) != target.charAt(i1)){
                    break;
                }
                temp++;
            }
            if(temp == sunLen){
                return i;
            }
        }
        return -1;
    }


    public int strMatchKMP(String source,String target){



        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new KMP().strMatch("AAAAAABC", "AAAB"));
        System.out.println(new KMP().strMatch("AAAAAABC", "AAAC"));
        System.out.println(new KMP().strMatch("AAAAAABC", ""));
        System.out.println(new KMP().strMatch("", "A"));
    }
}
