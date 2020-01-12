package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/11 12:59 下午
 */
public class No695MaxAreaOfIsland {
    private int[][] grid;
    private boolean[][] marked;
    private int m;
    private int n;
    private int maxArea = 0;
    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        this.marked = new boolean[m][n];
        this.grid = grid;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (marked[i][j]) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int i, int j) {
        int result = 0;
        if (marked[i][j]) {
            return 0;
        }
        marked[i][j] = true;
        result = 1;
        for (int k = 0; k < 4; ++k) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY) && grid[newX][newY] == 1) {
                result += dfs(newX, newY);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        No695MaxAreaOfIsland solution = new No695MaxAreaOfIsland();
        System.out.println(solution.maxAreaOfIsland(grid));
    }
}
