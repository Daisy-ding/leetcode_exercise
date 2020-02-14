package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/18 10:15 下午
 */
public class No1254NumberOfClosedIslands {
    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private List<List<Point>> regions = new ArrayList<>();
    private int[][] grid;
    private boolean[][] marked;
    private int m;
    private int n;
    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public int closedIsland(int[][] grid) {
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
                if (grid[i][j] == 0) {
                    if (marked[i][j]) {
                        continue;
                    }
                    List<Point> region = new LinkedList<>();
                    dfs(i, j, region);
                    regions.add(region);
                }
            }
        }
        int result = 0;
        for (List<Point> region : regions) {
            if (region.isEmpty()) {
                continue;
            }
            boolean valid = true;
            for (Point point : region) {
                if (point.x == 0 || point.y == 0 || point.x == m - 1 || point.y == n - 1) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result++;
            }
        }
        return result;
    }

    private void dfs(int i, int j, List<Point> region) {
        if (marked[i][j]) {
            return;
        }
        marked[i][j] = true;
        region.add(new Point(i, j));
        for (int k = 0; k < 4; ++k) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY) && grid[newX][newY] == 0) {
                region.add(new Point(newX, newY));
                dfs(newX, newY, region);
            }
        }
    }

    public static void main(String[] args) {
        No1254NumberOfClosedIslands solution = new No1254NumberOfClosedIslands();
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        System.out.println(solution.closedIsland(grid));
    }
}
