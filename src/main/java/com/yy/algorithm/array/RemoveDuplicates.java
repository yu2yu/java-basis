package com.yy.algorithm.array;

import java.util.Arrays;

/**
 * @version 1.0
 * @description: 删除重复元素
 * @author: yy
 * @date: 2020/12/25
 */
public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] nums){
        // 删除数组中重复元素留下一个
        int min = 0,len = nums.length;
        for (int i = 0; i < len-1; i++) {
            if(nums[i] != nums[i+1]){
                min++;
                // 防止自引用
                if( ((i+1) - min) > 0) {
                    nums[min] = nums[i + 1];
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,2,3};
        Arrays.stream(removeDuplicates(arr)).forEach(System.out::print);
    }

}
