package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/3 12:37 上午
 */
public class No896MonotonicArray {
    public boolean isMonotonic(int[] A) {
        int first = A[0];
        int last = A[A.length - 1];
        int diff = Integer.compare(first, last);
        if (diff == 0) {
            for (int element : A) {
                if (element != first) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < A.length - 1; ++i) {
                if (Integer.compare(A[i], A[i + 1]) == (0 - diff)) {
                    return false;
                }
            }
            return true;
        }
    }
}
