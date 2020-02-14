package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/4 2:20 上午
 */
public class No888FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int a : A) {
            sumA += a;
        }
        for (int b : B) {
            sumB += b;
        }
        int average = (sumA + sumB) / 2;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B.length; ++j) {
                if (A[i] - B[j] == sumA - average) {
                    return new int[]{A[i], B[j]};
                }
            }
        }
        return new int[]{0, 0};
    }
}
