package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang
 * @date 2019/12/8 7:03 下午
 */
public class No1005MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0;
        int negativeCount = 0;
        Arrays.sort(A);
        for (int a : A) {
            sum += a;
            if (a < 0) {
                negativeCount++;
            }
        }
        if (negativeCount == 0) {
            if (K % 2 == 0) {
                return sum;
            } else {
                return sum - 2 * A[0];
            }
        } else {
            if (negativeCount >= K) {
                for (int i = 0; i < K; ++i) {
                    sum -= 2 * A[i];
                }
            } else {
                for (int i = 0; i < negativeCount; ++i) {
                    sum -= 2 * A[i];
                }
                if ((K - negativeCount) % 2 == 1) {
                    int minAbs = Integer.MAX_VALUE;
                    for (int a : A) {
                        if (Math.abs(a) < minAbs) {
                            minAbs = Math.abs(a);
                        }
                    }
                    sum -= 2 * minAbs;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        No1005MaximizeSumOfArrayAfterKNegations solution = new No1005MaximizeSumOfArrayAfterKNegations();
        int[] A = new int[]{2, -3, -1, 5, -4};
        System.out.println(solution.largestSumAfterKNegations(A, 2));
    }
}
