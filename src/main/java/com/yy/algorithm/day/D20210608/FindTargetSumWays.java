package com.yy.algorithm.day.D20210608;

import org.junit.Test;

public class FindTargetSumWays {

    int count = 0;

    public int findTargetSumWays(int[] nums,int target){
        backTar(0,nums,0,target);
        return count;
    }


    public void backTar(int sum,int[] nums,int index,int target){
        if(index == nums.length){
            if(sum == target){
                count++;
            }
        }else{
            backTar(sum+nums[index],nums,index+1,target);
            backTar(sum-nums[index],nums,index+1,target);
        }
    }


    public int findTargetSumWaysTwo(int[] nums,int target){

        return count;
    }

    @Test
    public void testFind(){
        assert 5 == findTargetSumWays(new int[]{1,1,1,1,1},3);
    }

}
