package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/11 10:30 下午
 */
public class No191NumberOf1Bits {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += (n & 1);
            n = n >>> 1;
        }
        return result;
    }
}
