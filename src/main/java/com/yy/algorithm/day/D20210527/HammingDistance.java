package com.yy.algorithm.day.D20210527;


import org.junit.Test;

/**
 * @Description 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 */
public class HammingDistance {

    /**
     * use for to x,y is too large
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int count = 0;
        int result = x ^ y;
        // 计算出二进制中1的个数
        char[] binaryStrings = Integer.toBinaryString(result).toCharArray();
        for (char binaryString : binaryStrings) {
            if(binaryString == '1'){
                count++;
            }
        }
        return count;
    }

    public int hammingDistanceTwo(int x, int y) {
        return Integer.bitCount(x^y);
    }

    public int hammingDistanceThree(int x, int y) {
        int s = x^y,result = 0;
        while(s != 0){
            result += s & 1;
            s >>= 1;
        }
        return result;
    }

    public int hammingDistanceFour(int x, int y) {
        int s = x^y,result = 0;
        while(s != 0){
            s &= s-1;
            result++;
        }
        return result;
    }

    @Test
    public void testBinaryString(){
        System.out.println(hammingDistanceTwo(1,4));
        System.out.println(hammingDistanceThree(1,4));
        System.out.println(hammingDistanceFour(1,4));
    }

}
