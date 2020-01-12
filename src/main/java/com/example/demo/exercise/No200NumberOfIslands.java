package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/11 12:10 下午
 */
public class No200NumberOfIslands {
    private int result = 0;
    private boolean[][] marked;
    private int m;
    private int n;
    private char[][] grid;
    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        this.m = m;
        this.n = n;
        this.grid = grid;
        this.marked = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (marked[i][j]) {
                    continue;
                }
                if (grid[i][j] == '1') {
                    result++;
                    dfs(i, j);
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j) {
        if (marked[i][j] == true) {
            return;
        }
        marked[i][j] = true;
        for (int k = 0; k < 4; ++k) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY) && grid[newX][newY] == '1') {
                dfs(newX, newY);
            }
        }
    }
}
