package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/28 10:26 下午
 */
public class No766ToeplitzMatrix {
    private boolean diagonalEquals(int[][] matrix, int m, int n, int[] startPoint) {
        int value = matrix[startPoint[0]][startPoint[1]];
        while (startPoint[0] < m && startPoint[1] < n) {
            if (value != matrix[startPoint[0]][startPoint[1]]) {
                return false;
            }
            startPoint[0]++;
            startPoint[1]++;
        }
        return true;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] startPoints = new int[m + n - 1][2];
        startPoints[0][0] = 0;
        startPoints[0][1] = 0;
        int k = 1;
        for (int j = 1; j < n; ++j) {
            startPoints[k][0] = 0;
            startPoints[k][1] = j;
            k++;
        }
        for (int i = 1; i < m; ++i) {
            startPoints[k][0] = i;
            startPoints[k][1] = 0;
            k++;
        }
        for (int[] startPoint : startPoints) {
            if (!diagonalEquals(matrix, m, n, startPoint)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No766ToeplitzMatrix solution = new No766ToeplitzMatrix();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };

        System.out.println(solution.isToeplitzMatrix(matrix));
    }
}
