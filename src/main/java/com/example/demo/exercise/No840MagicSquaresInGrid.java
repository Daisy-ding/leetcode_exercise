package com.example.demo.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yubang
 * @date 2020/1/1 12:11 上午
 */
public class No840MagicSquaresInGrid {
    private boolean isMagicSquares(int x00, int x01, int x02,
                                   int x10, int x11, int x12,
                                   int x20, int x21, int x22) {
        Set<Integer> set = new HashSet<>();
        if (x00 >= 1 && x00 <= 9) {
            set.add(x00);
        }
        if (x01 >= 1 && x01 <= 9) {
            set.add(x01);
        }
        if (x02 >= 1 && x02 <= 9) {
            set.add(x02);
        }
        if (x10 >= 1 && x10 <= 9) {
            set.add(x10);
        }
        if (x11 >= 1 && x11 <= 9) {
            set.add(x11);
        }
        if (x12 >= 1 && x12 <= 9) {
            set.add(x12);
        }
        if (x20 >= 1 && x20 <= 9) {
            set.add(x20);
        }
        if (x21 >= 1 && x21 <= 9) {
            set.add(x21);
        }
        if (x22 >= 1 && x22 <= 9) {
            set.add(x22);
        }
        int lineSum0 = x00 + x01 + x02;
        int lineSum1 = x10 + x11 + x12;
        int lineSum2 = x20 + x21 + x22;
        int columnSum0 = x00 + x10 + x20;
        int columnSum1 = x01 + x11 + x21;
        int columnSum2 = x02 + x12 + x22;
        return set.size() == 9 && lineSum0 == lineSum1 && lineSum0 == lineSum2 && lineSum0 == (x00 + x11 + x22) && lineSum0 == (x02 + x11 + x20) &&
                lineSum0 == columnSum0 && lineSum0 == columnSum1 && lineSum2 == columnSum2;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        for (int i = 0; i <= grid.length - 3; ++i) {
            for (int j = 0; j <= grid[0].length - 3; ++j) {
                if (isMagicSquares(grid[i][j], grid[i][j + 1], grid[i][j + 2],
                        grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                        grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2])) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No840MagicSquaresInGrid solution = new No840MagicSquaresInGrid();
        int[][] grid = new int[][]{{2, 7, 6}, {1, 5, 9}, {4, 3, 8}};
        System.out.println(solution.numMagicSquaresInside(grid));
    }
}
