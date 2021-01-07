package com.yy.algorithm.DP;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/6
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle){
        // 状态转移方程
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            // 状态转移
            f[i][0] = f[i-1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i-1][j-1],f[i-1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
        }
        int minTotal = f[n-1][0];
        for (int i = 0; i < n; i++) {
            minTotal = Math.min(minTotal,f[n-1][i]);
        }
        return minTotal;
    }

    public int minimumTotal2(List<List<Integer>> triangle){


        return 0;
    }


    public static void main(String[] args) {
        ArrayList<Integer> l1 = Lists.newArrayList(1);
        ArrayList<Integer> l2 = Lists.newArrayList(2,1);
        ArrayList<Integer> l3 = Lists.newArrayList(4,2,3);
        ArrayList<Integer> l4 = Lists.newArrayList(1,2,3,4);

        ArrayList<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        System.out.println(new MinimumTotal().minimumTotal(list));
    }
}
