package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/2 8:24 下午
 */
public class No845LongestMountainInArray {
    public int longestMountain(int[] A) {
        int N = A.length;
        int result = 0;
        int base = 0;
        while (base < N) {
            int end = base;
            if (end + 1 < N && A[end] < A[end + 1]) {
                while (end + 1 < N && A[end] < A[end + 1]) {
                    end++;
                }
                if (end + 1 < N && A[end] > A[end + 1]) {
                    while (end + 1 < N && A[end] > A[end + 1]) {
                        end++;
                    }
                    result = Math.max(result, end - base + 1);
                }
            }
            base = Math.max(end, base + 1);
        }
        return result;
    }
}
