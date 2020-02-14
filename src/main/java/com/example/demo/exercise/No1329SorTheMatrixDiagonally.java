package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/2/5 9:53 下午
 */
public class No1329SorTheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {
        if (mat.length == 0) {
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        int dLen = m + n - 1;
        List<Integer>[] diagonals = new ArrayList[dLen];
        for (int i = 0; i < dLen; ++i) {
            diagonals[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                diagonals[j - i + (m - 1)].add(mat[i][j]);
            }
        }
        for (int i = 0; i < dLen; ++i) {
            diagonals[i].sort(Integer::compareTo);
        }

        int[] next = new int[dLen];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int index = j - i + (m - 1);
                mat[i][j] = diagonals[index].get(next[index]);
                next[index]++;
            }
        }
        return mat;
    }
}
