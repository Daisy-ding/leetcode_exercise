package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/25 11:41 下午
 */
public class No263UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 1) {
            return false;
        } else if (num <= 6) {
            return true;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
}
