package com.yy.algorithm.DP;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/31
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if(n<1) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        // 做决策，递归不好
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairs2(int n) {
        int p = 0,q = 0,total = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = total;
            total = p + q;
        }
        return total;
    }


    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs2(4));
    }
}
