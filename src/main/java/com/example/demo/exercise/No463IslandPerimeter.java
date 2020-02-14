package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/29 10:39 下午
 */
public class No463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    if (i != m - 1 && grid[i + 1][j] == 1) {
                        perimeter -= 2;
                    }
                    if (j != n - 1 && grid[i][j + 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        No463IslandPerimeter solution = new No463IslandPerimeter();
        int[][] island = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println(solution.islandPerimeter(island));
    }
}
