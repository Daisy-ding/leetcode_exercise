package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/27 12:55 上午
 */
public class No367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No367ValidPerfectSquare solution = new No367ValidPerfectSquare();
        System.out.println(solution.isPerfectSquare(808201));
    }
}
