package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang
 * @date 2019/12/1 7:54 下午
 */
public class No976LargestPerimeterTriangle {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int[] reverseA = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            reverseA[i] = A[A.length - i - 1];
        }

        int i = 2;
        while (i < A.length) {
            int third = reverseA[i - 2];
            int second = reverseA[i - 1];
            int first = reverseA[i];
            if (third < second + first) {
                return third + second + first;
            }
            i++;
        }
        return 0;
    }
}
