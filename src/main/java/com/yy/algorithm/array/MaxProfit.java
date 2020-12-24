package com.yy.algorithm.array;

import java.util.Arrays;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/23
 */
public class MaxProfit {

    /**
     * 只允许买卖一次
     * @param profits
     * @return
     */
    public static int maxProfitOne(int[] profits){
        int maxProfits = 0;
        for (int i = 0; i < profits.length - 1; i++) {
            for (int i1 = i+1; i1 < profits.length; i1++) {
                if((profits[i1] - profits[i]) > maxProfits){
                    maxProfits = profits[i1] - profits[i];
                }
            }
        }
        return maxProfits;
    }

    public static int maxProfitTwo(int[] prices){
        if(prices.length < 2) return 0;
        // 最低价
        int min = prices[0];
        // 最高收益
        int maxProfit = 0;
        for (int price : prices) {
            min = Math.min(price, min);
            maxProfit = Math.max((price - min), maxProfit);
        }
        return maxProfit;
    }

    // 不限制购买股票的次数

    /**
     * 贪心算法，总是算出当前有利的选择
     * @param prices
     * @return
     */
    public static int maxProfitThree(int[] prices){
        if(prices.length < 2) return 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int sub = prices[i + 1] - prices[i];
            if (sub > 0) maxProfit += sub;
        }
        return maxProfit;
    }
    // DP
    public static int maxProfitFour(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{7,1,5,3,6,4};
        int[] arr = new int[]{7,1,5,8,9,4};
        System.out.println(maxProfitThree(arr));
    }

}
