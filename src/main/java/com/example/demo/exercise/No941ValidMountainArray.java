package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/28 7:45 下午
 */
public class No941ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int top = A[0];
        int topIndex = 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] > top) {
                top = A[i];
                topIndex = i;
            }
        }
        if (topIndex == 0 || topIndex == A.length - 1) {
            return false;
        }
        for (int i = 0; i < topIndex; ++i) {
            if (A[i] >= A[i + 1]) {
                return false;
            }
        }
        for (int i = topIndex; i < A.length; ++i) {
            if (i == A.length - 1) {
                continue;
            }
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
