package com.yy.algorithm.DP;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/31
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if(nums == null) return 0;
        int sum = nums[0],max = nums[0],size = nums.length;
        for (int num : nums) {
            sum = Math.max(num,sum+num);
            max = Math.max(max,sum);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,-1}));
    }
}
