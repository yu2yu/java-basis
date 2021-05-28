package com.yy.algorithm.day.D20210528;


import org.junit.Test;

/**
 * @Description 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 *
 *
 */
public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int sum = 0,length = nums.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                sum += hammingDistance(nums[i],nums[j]);
            }
        }
        return sum;
    }

    public int hammingDistance(int num1,int num2){
        return Integer.bitCount(num1^num2);
    }

    public int totalHammingDistanceTwo(int[] nums) {
        int total = 0,n = nums.length;
        for (int i = 0; i < 30;++i) {
            int sum = 0;
            for (int num : nums) {
                sum += (num>>i) &1;
            }
            total += sum * (n - sum);
        }

        return total;
    }


    @Test
    public void testTotalHammingDistance(){
        assert 6 == totalHammingDistance(new int[]{4,14,2});
        assert 6 == totalHammingDistanceTwo(new int[]{4,14,2});
    }

}
