package com.yy.algorithm.day.D20210519;


import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Description  找出第 K 大的异或坐标值
 *
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 */
public class KthLargestValue {


    public int kthLargestValue(int[][] matrix, int k) {
        int width = matrix.length;
        int column = matrix[0].length;
        int[][] pre = new int[width + 1][column + 1];
        // topK
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,(a,b) -> a-b);
        // 1. 求出所有的异或值
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= column; j++) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                if(queue.size() < k){
                    queue.add(pre[i][j]);
                }else{
                    if(queue.peek() < pre[i][j]){
                        queue.poll();
                        queue.add(pre[i][j]);
                    }
                }

            }
        }
        return queue.peek();
    }


    @Test
    public void testKthLargestValue() {
        int a[][]={{5,2},{1,6}};
        System.out.println(kthLargestValue(a, 1));
    }
}
