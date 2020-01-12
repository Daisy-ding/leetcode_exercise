package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/13 12:10 上午
 */
public class No172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int fiveCount = 0;
        while (n >= 5) {
            fiveCount += n / 5;
            n /= 5;
        }
        return fiveCount;
    }
}
