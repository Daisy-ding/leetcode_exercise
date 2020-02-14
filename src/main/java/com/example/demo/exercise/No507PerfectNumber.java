package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/28 7:35 下午
 */
public class No507PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }

        int sum = 0;
        int max = (int) Math.sqrt(num);
        for (int i = 1; i <= max; ++i) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        return sum == (2 * num);
    }

    public static void main(String[] args) {
        No507PerfectNumber solution = new No507PerfectNumber();
        System.out.println(solution.checkPerfectNumber(28));
    }
}
