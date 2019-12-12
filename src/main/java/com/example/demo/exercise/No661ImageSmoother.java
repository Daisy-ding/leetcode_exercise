package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/12 11:19 下午
 */
public class No661ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int height = M.length;
        int width = M[0].length;
        int[][] results = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                int sum = 0;
                int count = 0;
                for (int k = i - 1; k <= i + 1; ++k) {
                    for (int m = j - 1; m <= j + 1; ++m) {
                        if (k >= 0 && k < height && m >= 0 && m < width) {
                            sum += M[k][m];
                            count++;
                        }
                    }
                }
                results[i][j] = sum / count;
            }
        }
        return results;
    }
}
