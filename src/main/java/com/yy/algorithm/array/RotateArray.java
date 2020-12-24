package com.yy.algorithm.array;

import java.util.Arrays;

/**
 * @version 1.0
 * @description: 旋转数组
 * @author: yy
 * @date: 2020/12/24
 */
public class RotateArray {

    public static int[] rotateOne(int[] nums,int k){
        k = k%nums.length;
        // 旋转数组，空间复杂度为 O(1),就是转换位置
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        return nums;
    }

    private static void reverse(int[] nums,int start,int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


    public static int[] rotateTwo(int[] nums,int k){
        // 直接环状替换,每次跳跃k步
        int count=0,len = nums.length;
        for (int start = 0; count < len; start++) {
            int current = start;
            int prev = nums[start];
            do{
                //每次跳跃k步
                int next = (current + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
                // 结束条件为开始点
            }while(current != start);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        Arrays.stream(rotateOne(arr, 3)).mapToObj(k -> k+",").forEach(System.out::print);
    }

}
