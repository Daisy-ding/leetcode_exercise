package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/4 4:14 下午
 */
public class No1219PathWithMaximumGold {
    private boolean[][] marked;
    private int m;
    private int n;
    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int result = 0;
    private int[][] grid;

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        marked = new boolean[m][n];
        this.grid = grid;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    dfs(i, j, grid[i][j]);
                }
            }
        }
        return result;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private void dfs(int i, int j, int sum) {
        if (marked[i][j]) {
            return;
        }
        result = Math.max(sum, result);
        marked[i][j] = true;
        for (int k = 0; k < 4; ++k) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY) && grid[newX][newY] > 0) {
                dfs(newX, newY, sum + grid[newX][newY]);
            }
        }
        marked[i][j] = false;
    }
}
