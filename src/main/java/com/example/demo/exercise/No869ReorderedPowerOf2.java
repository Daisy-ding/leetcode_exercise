package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/31 11:15 下午
 */
public class No869ReorderedPowerOf2 {
    private boolean bucketEquals(int[] A, int[] B) {
        for (int i = 0; i <= 9; ++i) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean reorderedPowerOf2(int N) {
        if (N <= 0) {
            return false;
        }
        int[] buckets = new int[10];
        int digitsCount = 0;
        while (N > 0) {
            buckets[N % 10]++;
            N = N / 10;
            digitsCount++;
        }
        int min = (int) Math.pow(10, digitsCount - 1);
        int max = (int) Math.pow(10, digitsCount) - 1;
        int target = 1;
        while (true) {
            if (target > max) {
                return false;
            }
            if (target >= min && target <= max) {
                int[] newBuckets = new int[10];
                int temp = target;
                while (temp > 0) {
                    newBuckets[temp % 10]++;
                    temp = temp / 10;
                }
                if (bucketEquals(buckets, newBuckets)) {
                    return true;
                }
            }
            target *= 2;
        }
    }

    public static void main(String[] args) {
        No869ReorderedPowerOf2 solution = new No869ReorderedPowerOf2();
        System.out.println(solution.reorderedPowerOf2(1));
    }
}
