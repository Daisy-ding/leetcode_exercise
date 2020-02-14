package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/8 5:45 下午
 */
public class No371SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
