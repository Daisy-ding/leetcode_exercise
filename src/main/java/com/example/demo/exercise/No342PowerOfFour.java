package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/14 2:52 下午
 */
public class No342PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        } else if (num == 1) {
            return true;
        }
        return (Math.log10(num) / Math.log10(4)) % 1 == 0;
    }
}
