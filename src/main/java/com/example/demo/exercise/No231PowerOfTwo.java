package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 2:42 下午
 */
public class No231PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        No231PowerOfTwo solution = new No231PowerOfTwo();
        System.out.println(solution.isPowerOfTwo(16));
    }
}
