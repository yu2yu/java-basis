package com.yy.algorithm.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2021/1/4
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] num){
        // 最差劲方法
        int size = num.length,max = 1;
        int[] dp = new int[size];
        dp[0] = 1;
        for (int i = 1; i < size; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(num[j] < num[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums){
        // 最差劲方法
        int flag = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            int i=0,j=flag;
            while(i<j){
                int m = (i + j) / 2;
                if(dp[m] < num) i = m + 1;
                else j = m;
            }
            dp[i] = num;
            if(flag == j) flag++;
        }
        return flag;
    }






    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new LengthOfLIS().lengthOfLIS2(new int[]{0,1,0,3,2,3}));
        System.out.println(new LengthOfLIS().lengthOfLIS2(new int[]{7,7,7,7,7,7,7}));
        System.out.println(new LengthOfLIS().lengthOfLIS2(new int[]{4,10,4,3,8,9}));
    }
}
