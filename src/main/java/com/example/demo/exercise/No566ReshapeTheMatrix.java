package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/30 4:06 下午
 */
public class No566ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] results = new int[r][c];
        int index = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                results[index / c][index % c] = nums[i][j];
                index++;
            }
        }
        return results;
    }
}
