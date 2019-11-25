package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 8:22 下午
 */
public class No832FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            for (int i = 0; i < row.length / 2; ++i) {
                int temp = row[i];
                row[i] = row[row.length - i - 1];
                row[row.length - i - 1] = temp;
            }
        }
        for (int[] row : A) {
            for (int i = 0; i < row.length; ++i) {
                if (row[i] == 1) {
                    row[i] = 0;
                } else {
                    row[i] = 1;
                }
            }
        }
        return A;
    }
}
