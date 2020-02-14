package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/4 2:05 上午
 */
public class No892SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int surfaceArea = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                int v = grid[i][j];
                surfaceArea += v == 0 ? 0 : 6 * v - 2 * (v - 1);
                if (j + 1 < grid[i].length) {
                    surfaceArea -= 2 * Math.min(grid[i][j], grid[i][j + 1]);
                }
                if (i + 1 < grid.length) {
                    surfaceArea -= 2 * Math.min(grid[i][j], grid[i + 1][j]);
                }
            }
        }
        return surfaceArea;
    }

    public static void main(String[] args) {
        No892SurfaceAreaOf3DShapes solution = new No892SurfaceAreaOf3DShapes();
        int[][] grid = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] grid = new int[][]{{1, 0}, {0, 2}};
//        int[][] grid = new int[][]{{1, 2}, {3, 4}};
        System.out.println(solution.surfaceArea(grid));
    }
}
