package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/29 3:55 下午
 */
public class No5295FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n % 2 == 0) {
            int low = 0 - n / 2;
            int high = n / 2;
            int i = 0;
            while (low < 0) {
                result[i++] = low++;
            }
            low = 1;
            while (low <= high) {
                result[i++] = low++;
            }
        } else {
            int low = 0 - n / 2;
            int i = 0;
            while (i < n) {
                result[i++] = low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No5295FindNUniqueIntegersSumUpToZero solution = new No5295FindNUniqueIntegersSumUpToZero();
        int[] results = solution.sumZero(1);
        for (int res : results) {
            System.out.print(res + " ");
        }
        System.out.println();
    }
}
