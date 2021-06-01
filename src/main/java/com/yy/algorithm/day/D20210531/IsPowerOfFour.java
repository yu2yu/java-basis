package com.yy.algorithm.day.D20210531;

import org.junit.Test;

/**
 * @Description:
 *          给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；
 *          否则，返回 false 。
 *          整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *
 */
public class IsPowerOfFour {


    /**
     * 2的幂
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }

    public boolean isPowerOfFour(int n) {
        return n>0 && (n&(n-1)) == 0 && (n%3 ==1);
    }

    @Test
    public void testPowerOfTwo(){
        assert  true==isPowerOfTwo(4);
        assert  false==isPowerOfTwo(5);
        assert  true==isPowerOfTwo(8);
    }

    @Test
    public void testPowerOfFour(){
        assert  true==isPowerOfFour(4);
        assert  false==isPowerOfFour(5);
        assert  true==isPowerOfFour(16);
    }

}
