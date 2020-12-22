package com.yy.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @version 1.0
 * @description: 两个数组的交集
 *                  其实就是
 * @author: yy
 * @date: 2020/12/22
 */
public class TwoArrayInter {


    public static int[] intersect(int[] num1,int[] num2){
        // 映射为Map
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i = 0,size = num1.length; i < size; i++) {
            int data = integerHashMap.get(num1[i])==null?0:integerHashMap.get(num1[i]);
            integerHashMap.put(num1[i],data+=1);
        }
        int k = 0;
        for (int i : num2) {
            Integer data = integerHashMap.get(i);
            if(data!= null && data > 0){
                data--;
                num2[k++] = i;
            }
        }
        return Arrays.copyOf(num2,k);
    }


    public static int[] sortIntersect(int[] num1,int[] num2){
        // 双指针
        Arrays.sort(num1);
        Arrays.sort(num2);
        int i = 0,j=0,k=0,arr1Size=num1.length,arr2Size=num2.length;
        while(i<arr1Size && j<arr2Size){
            // 相等
            if(num1[i] == num2[j]){
                num1[k++] = num1[i++];
                j++;
            }else if(num1[i] < num2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOf(num1,k);
    }

    public static void main(String[] args) {

        int[] num1 = new int[]{4,4,7,9,3};
        int[] num2 = new int[]{5,4,2,4,3};

        Arrays.stream(intersect(num1, num2)).forEach(System.out::print);

        System.out.println("");
        int[] num3 = new int[]{4,4,7,9,17};
        int[] num4 = new int[]{4,4,9,10,33};
        Arrays.stream(sortIntersect(num3, num4)).forEach(System.out::print);
    }

}
