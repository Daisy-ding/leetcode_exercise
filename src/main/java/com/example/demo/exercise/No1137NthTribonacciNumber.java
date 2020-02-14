package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/26 11:33 下午
 */
public class No1137NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int thdLast = 0;
        int secondLast = 1;
        int last = 1;
        int current = 0;
        int i = 3;
        while (i <= n) {
            current = thdLast + secondLast + last;
            if (i == n) {
                return current;
            } else {
                thdLast = secondLast;
                secondLast = last;
                last = current;
            }
            i++;
        }
        return current;
    }

    public static void main(String[] args) {
        No1137NthTribonacciNumber solution = new No1137NthTribonacciNumber();
        System.out.println(solution.tribonacci(25));
    }
}
