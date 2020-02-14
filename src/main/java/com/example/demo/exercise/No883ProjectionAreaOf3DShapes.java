package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/24 10:37 下午
 */
public class No883ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int n = grid.length;

        int noZeroCount = 0;
        int maxInColumnSum = 0;
        int maxInRowSum = 0;
        for (int i = 0; i < n; ++i) {
            int maxInRow = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > maxInRow) {
                    maxInRow = grid[i][j];
                }
                if (grid[i][j] != 0) {
                    noZeroCount++;
                }
            }
            maxInRowSum += maxInRow;
        }

        for (int j = 0; j < n; ++j) {
            int maxInColumn = 0;
            for (int i = 0; i < n; ++i) {
                if (grid[i][j] > maxInColumn) {
                    maxInColumn = grid[i][j];
                }
            }
            maxInColumnSum += maxInColumn;
        }
        return noZeroCount + maxInColumnSum + maxInRowSum;
    }

    public static void main(String[] args) {
        No883ProjectionAreaOf3DShapes solution = new No883ProjectionAreaOf3DShapes();
        int[][] inputs = new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(solution.projectionArea(inputs));
    }
}
