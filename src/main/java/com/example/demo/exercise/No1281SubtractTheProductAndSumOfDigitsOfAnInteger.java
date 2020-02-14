package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/10 10:06 上午
 */
public class No1281SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            product *= temp;
            sum += temp;
            n = n / 10;
        }
        return product - sum;
    }
}
