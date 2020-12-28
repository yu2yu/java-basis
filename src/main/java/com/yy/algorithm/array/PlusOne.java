package com.yy.algorithm.array;

import java.util.Arrays;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/28
 */
public class PlusOne {

    public int[] plusOne(int[] nums){
        // 加一，需要考虑是否是9,转换为真实的整数 100位 不合理
        int size = nums.length;
        for (int i = size-1; i >= 0; i--) {
            nums[i]++;
            nums[i] = nums[i] % 10;
            if(nums[i] != 0) return nums;
        }
        // 会维持原来数组的数据
        nums = new int[size + 1];
        nums[0] = 1;
        return nums;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{9,2};
        Arrays.stream(new PlusOne().plusOne(arr)).forEach(System.out::print);
    }

}
