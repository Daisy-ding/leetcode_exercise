package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/24 4:51 下午
 */
public class No509FibonacciNumber {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int lastSecond = 0;
        int last = 1;
        int i = 2;
        int current = 0;
        while (i <= N) {
            current = last + lastSecond;
            lastSecond = last;
            last = current;
            i++;
        }
        return current;
    }

    public static void main(String[] args) {
        No509FibonacciNumber solution = new No509FibonacciNumber();
        System.out.println(solution.fib(2));
    }
}
