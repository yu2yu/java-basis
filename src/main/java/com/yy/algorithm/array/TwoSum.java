package com.yy.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @version 1.0
 * @description:
 * @author: yy
 * @date: 2020/12/28
 */
public class TwoSum {

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums,int target){
        int size = nums.length;
        for (int i = 0; i < size-1; i++) {
            for (int i1 = i+1; i1 < size; i1++) {
                if ((nums[i] + nums[i1]) == target) {
                    return new int[]{i,i1};
                }
            }
        }
        return null;
    }


    public int[] twoSum2(int[] nums,int target){
        // 排序
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (map.get(nums[i]) == null) {
                map.put(target-nums[i],i);
            }else {
                return new int[]{map.get(nums[i]),i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7,7, 11, 15};
        Arrays.stream(new TwoSum().twoSum2(arr, 9)).forEach(System.out::print);
    }

}
