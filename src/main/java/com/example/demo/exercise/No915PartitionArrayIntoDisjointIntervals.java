package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/16 12:21 上午
 */
public class No915PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int[] leftMax = new int[A.length];
        int[] rightMin = new int[A.length];
        int lm = A[0];
        for (int i = 0; i < A.length; ++i) {
            lm = Math.max(lm, A[i]);
            leftMax[i] = lm;
        }
        int rm = A[A.length - 1];
        for (int i = A.length - 1; i >= 0; --i) {
            rm = Math.min(rm, A[i]);
            rightMin[i] = rm;
        }

        for (int i = 1; i < A.length; ++i) {
            if (leftMax[i - 1] <= rightMin[i]) {
                return i;
            }
        }
        return -1;
    }
}
