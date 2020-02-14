package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/27 12:48 上午
 */
public class No633SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int low = 0;
        int high = (int) Math.sqrt(c);
        while (low <= high) {
            int sum = low * low + high * high;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No633SumOfSquareNumbers solution = new No633SumOfSquareNumbers();
        System.out.println(solution.judgeSquareSum(2));
    }
}
