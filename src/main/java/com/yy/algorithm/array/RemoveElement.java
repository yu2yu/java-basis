package com.yy.algorithm.array;

import java.util.Arrays;

/**
 * @version 1.0
 * @description: 移除元素
 * @author: yy
 * @date: 2020/12/25
 */
public class RemoveElement {


    /**
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums,int val){
        // 需要原地删除，不能借助其他额外空间
        int len = nums.length,count=0;
        for (int i = 0; i < len; i++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }


    public static int removeElementTwo(int[] nums,int val){
        int len = nums.length,count=0;
        while(count<len) {
            if(nums[count] == val) {
                nums[count] = nums[len-1];
                len--;
            }else{
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,2,4,3,7,4};
        System.out.println(removeElementTwo(arr, 4));
        Arrays.stream(arr).forEach(System.out::print);
    }

}
