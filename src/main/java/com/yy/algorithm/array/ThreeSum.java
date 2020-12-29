package com.yy.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 *                  使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *                  注意：答案中不可以包含重复的三元组。
 * @author: yy
 * @date: 2020/12/29
 */
public class ThreeSum {

    /**
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */
    public List<List<Integer>> threeSum(int[] nums){
        // 排序 -4 -1 -1 0 1 2
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        // 遍历 左右指针
        int size = nums.length;
        int left=1,right=size-1;
        for (int i = 0; i < size-2; i++) {
            int sum = -nums[i];
            if (nums[i] > 0) break;
            // 跳过循环
            if(i==0 || nums[i] != nums[i-1]) {
                // 左右指针
                while (left < right) {
                    if (sum > (nums[left] + nums[right])) {
                        left++;
                    } else if (sum == (nums[left] + nums[right])) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // 避免重复
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else {
                        right--;
                    }
                }
            }
            // 重复利用
            left=i+2;
            right=size-1;
        }
        return res;
    }

    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

}
