package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 7:45 下午
 */
public class No1252CellsWithOddValuesInAMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] M = new int[n][m];
        for (int[] indice : indices) {
            int ri = indice[0];
            for (int i = 0; i < m; ++i) {
                M[ri][i] += 1;
            }

            int ci = indice[1];
            for (int i = 0; i < n; ++i) {
                M[i][ci] += 1;
            }
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (M[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No1252CellsWithOddValuesInAMatrix solution = new No1252CellsWithOddValuesInAMatrix();
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(solution.oddCells(2, 3, indices));
    }
}
