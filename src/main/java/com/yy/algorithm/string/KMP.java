package com.yy.algorithm.string;

/**
 * @description: KMP算法
 * @author: yy
 * @date: 2021/1/12
 */
public class KMP {

    private int[] next;
    private char[] pats;
    private String pat;

    public KMP(String pat) {
        //构建next数组
        this.pat = pat;
        pats = pat.toCharArray();
        setStrNext(pat);
    }

    private void setStrNext(String str){
        next = new int[str.length()];
        int i = 1,now = 0,len = str.length();
        while(i<len){
            if(pats[i] == pats[now]){
                now++;
                next[i] = now;
                i++;
            }else if(now != 0){
                now = next[now-1];
            }else{
                next[i] = 0;
                i++;
            }
        }
    }

    /**
     * next数组索引
     * @param str
     */
    public int strMatch(String str){
        int len = str.length(),subLen = pats.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if(str.charAt(i) == pats[j]){
                j++;
            }else{
                if(j != 0){
                    j = next[j - 1];
                }
            }
            if(j == subLen) return i-j+1;
        }
        return -1;
    }


    /**
     * 暴力解法
     * @param source
     * @return
     */
    public int strMatch2(String source){
        int len = source.length(),sunLen = pat.length();
        for (int i = 0; i < len-sunLen; i++) {
            int temp = 0;
            for (int i1 = 0; i1 < sunLen; i1++) {
                if(source.charAt(i+temp) != pat.charAt(i1)){
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


}
