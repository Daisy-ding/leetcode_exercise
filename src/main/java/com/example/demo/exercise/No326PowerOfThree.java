package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/14 2:48 下午
 */
public class No326PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}
