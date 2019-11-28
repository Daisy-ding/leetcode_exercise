package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/27 11:35 下午
 */
public class No867TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] result = new int[col][row];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No867TransposeMatrix solution = new No867TransposeMatrix();
        int[][] inputs = new int[][]{
                {1, 2, 3}, {4, 5, 6}};
        int[][] outputs = solution.transpose(inputs);

        for (int i = 0; i < outputs.length; ++i) {
            for (int j = 0; j < outputs[i].length; ++j) {
                System.out.println(outputs[i][j]);
            }
        }
    }
}
