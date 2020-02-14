package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/8 12:29 上午
 */
public class No69SqrtX {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        int lo = 1, hi = Math.min(x / 2, 46340);
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int diff = mid * mid - x;
            if (diff == 0) {
                return mid;
            } else if (diff > 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
        No69SqrtX solution = new No69SqrtX();
        System.out.println(solution.mySqrt(2147483647));
    }
}
