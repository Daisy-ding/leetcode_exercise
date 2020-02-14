package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang
 * @date 2019/11/23 9:36 下午
 */
public class No977SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            if (A[i] < 0) {
                A[i] = 0 - A[i];
            }
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; ++i) {
            A[i] = A[i] * A[i];
        }
        return A;
    }
}
