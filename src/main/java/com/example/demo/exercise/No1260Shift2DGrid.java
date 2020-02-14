package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/11/30 4:13 下午
 */
public class No1260Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        while (k > 0) {
            if (n > 1) {
                for (int i = 0; i < m; ++i) {
                    int temp = grid[i][n - 1];
                    for (int j = n - 2; j >= 0; --j) {
                        grid[i][j + 1] = grid[i][j];
                    }
                    grid[i][0] = temp;
                }
            }
            int temp = grid[m - 1][0];
            for (int i = m - 2; i >= 0; --i) {
                grid[i + 1][0] = grid[i][0];
            }
            grid[0][0] = temp;
            k--;
        }
        List<List<Integer>> results = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            List<Integer> result = new LinkedList<>();
            for (int j = 0; j < n; ++j) {
                result.add(grid[i][j]);
            }
            results.add(result);
        }
        return results;
    }

    public static void main(String[] args) {
        No1260Shift2DGrid solution = new No1260Shift2DGrid();
        int[][] inputs = new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}};
        List<List<Integer>> output = solution.shiftGrid(inputs, 23);
    }
}
