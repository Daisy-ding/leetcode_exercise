package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/4 11:08 下午
 */
public class No258AddDigits {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        if (sum % 9 == 0) {
            return 9;
        } else {
            return sum % 9;
        }
    }

    public static void main(String[] args) {
        No258AddDigits solution = new No258AddDigits();
        System.out.println(solution.addDigits(38));
    }
}
