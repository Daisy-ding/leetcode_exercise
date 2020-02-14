package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/12 11:58 下午
 */
public class No1317ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    private boolean containZero(int i) {
        int j;
        while (i > 0) {
            j = i % 10;
            if (j == 0) {
                return true;
            }
            i = i / 10;
        }
        return false;
    }

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; ++i) {
            if (containZero(i)) {
                continue;
            }
            int j = n - i;
            if (containZero(j)) {
                continue;
            }
            return new int[]{i, j};
        }
        return new int[]{0, 0};
    }
}
