package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 3:58 下午
 */
public class No922SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int halfLength = A.length / 2;
        int[] oddArray = new int[halfLength];
        int[] evenArray = new int[halfLength];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                evenArray[evenIndex++] = A[i];
            } else {
                oddArray[oddIndex++] = A[i];
            }
        }
        for (int i = 0; i < A.length; ++i) {
            if (i % 2 == 0) {
                A[i] = evenArray[i / 2];
            } else {
                A[i] = oddArray[i / 2];
            }
        }
        return A;
    }

    public static void main(String[] args) {
        No922SortArrayByParityII solution = new No922SortArrayByParityII();
        int[] inputs = new int[]{4, 2, 5, 7};
        int[] outputs = solution.sortArrayByParityII(inputs);
        for (int o : outputs) {
            System.out.println(o);
        }
    }
}
