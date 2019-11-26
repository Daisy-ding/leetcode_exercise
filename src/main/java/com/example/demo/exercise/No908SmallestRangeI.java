package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/25 11:44 下午
 */
public class No908SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int diff = max - min;
        if (diff > 2 * K) {
            return diff - 2 * K;
        } else {
            return 0;
        }
    }
}
