package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/2 10:38 下午
 */
public class No1013PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int element : A) {
            sum += element;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int average = sum / 3;
        int i = 0;
        int j = i + 1;
        int subSum = A[i];
        while (i < A.length && j < A.length) {
            if (subSum == average) {
                i = j;
                j = i + 1;
                subSum = A[i];
            } else {
                subSum += A[j];
                j++;
            }
        }
        return subSum == average || subSum == 0;
    }

    public static void main(String[] args) {
        No1013PartitionArrayIntoThreePartsWithEqualSum solution = new No1013PartitionArrayIntoThreePartsWithEqualSum();
        int[] inputs = new int[]{12, -4, 16, -5, 9, -3, 3, 8, 0};
        System.out.println(solution.canThreePartsEqualSum(inputs));
    }
}
