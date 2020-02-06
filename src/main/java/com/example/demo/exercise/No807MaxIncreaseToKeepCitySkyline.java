package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/5 11:00 下午
 */
public class No807MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowMaxes = new int[m];
        int[] colMaxes = new int[n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rowMaxes[i] = Math.max(rowMaxes[i], grid[i][j]);
                colMaxes[j] = Math.max(colMaxes[j], grid[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                result += Math.min(rowMaxes[i], colMaxes[j]) - grid[i][j];
            }
        }
        return result;
    }
}
