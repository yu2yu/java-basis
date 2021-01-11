package com.yy.algorithm.string;

import java.util.Arrays;

/**
 * @description: 大数打印
 * @author: yy
 * @date: 2021/1/11
 */
public class PrintBigNumber {

    /**
     * 位数有限
     * @param n
     * @return
     */
    public int[] printNumbers(int n){
        int len = (int) Math.pow(10,n);
        int[] nums = new int[len-1];
        for (int i = 1; i < len; i++) {
            nums[i-1] = i;
        }
        return nums;
    }

    public int[] printNumbers2(int n){
        int len = 1;
        for (int i = 0; i < n; i++) {
            len = len * 10;
        }
        int[] nums = new int[len];
        for (int i = 1; i < len; i++) {
            nums[i] = i;
        }
        return nums;
    }


    /**
     * 如果已经超越的long类型的最大值则需要用char类型来转换
     * @param n
     * @return
     */
    public void printNumbers3(int n){
        char[] ch = new char[n];
        for(int i=0;i<n;i++){
            ch[i]='0';
        }
        while(!increment(ch)){
            printNumber(ch);//打印
        }
    }

    public void printNumber(char[] ch){
        boolean flag=true;
        for(int i=0;i<ch.length;i++){
            if(flag&&ch[i]!='0'){
                flag=false;
            }
            if(!flag){
                System.out.print(ch[i]);
            }
        }
        System.out.print('\t');
    }

    public boolean increment(char[] ch){
        boolean overFlag = false;
        int flag = 0;
        int len = ch.length;
        // 如何计算ch的加1
        for (int i = len-1; i > 0; i--) {
            int sum = ch[i] - '0' + flag;
            if(i == len){
                sum++;
            }
            if(sum >= 10){
                if(i==0){
                    overFlag = true;
                    break;
                }
                flag = 1;
                ch[i] = '0';
            }else{
                ch[i] = '0';
                ch[i]+=sum;
                break;
            }
        }
        return overFlag;
    }


    public static void main(String[] args) {
//        Arrays.stream(new PrintBigNumber().printNumbers(1)).forEach( k -> System.out.print(k+","));
//        Arrays.stream(new PrintBigNumber().printNumbers2(2)).forEach( k -> System.out.print(k+","));
        new PrintBigNumber().printNumbers3(2);
    }



}
