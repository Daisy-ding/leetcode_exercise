package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yubang
 * @date 2020/1/18 11:54 下午
 */
public class No994RottingOranges {
    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int m;
    private int n;
    private int[][] grid;
    Queue<Point> queue = new LinkedList<>();

    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        this.grid = grid;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        int result = 0;
        int lastRotCount = queue.size();
        do {
            rotting(lastRotCount);
            if (queue.size() == 0) {
                break;
            } else {
                lastRotCount = queue.size();
                result++;
            }
        } while (true);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return result;
    }

    private void rotting(int rotCount) {
        for (int i = 0; i < rotCount; ++i) {
            Point first = queue.poll();
            for (int k = 0; k < 4; ++k) {
                int newX = first.x + directions[k][0];
                int newY = first.y + directions[k][1];
                if (inArea(newX, newY) && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    queue.add(new Point(newX, newY));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        No994RottingOranges solution = new No994RottingOranges();
        System.out.print(solution.orangesRotting(grid));
    }
}
