package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 2:19 下午
 */
public class No598RangeAdditionII {
    public int maxCountBruteForce(int m, int n, int[][] ops) {
        int[][] M = new int[m][n];
        for (int[] op : ops) {
            for (int i = 0; i < op[0]; ++i) {
                for (int j = 0; j < op[1]; ++j) {
                    M[i][j]++;
                }
            }
        }
        int max = -1;
        int maxCount = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (M[i][j] > max) {
                    max = M[i][j];
                    maxCount = 1;
                } else if (M[i][j] == max) {
                    maxCount++;
                }
            }
        }
        return maxCount;
    }

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int minX = ops[0][0];
        int minY = ops[0][1];
        for (int[] op : ops) {
            if (op[0] < minX) {
                minX = op[0];
            }
            if (op[1] < minY) {
                minY = op[1];
            }
        }
        return minX * minY;
    }

    public static void main(String[] args) {
        No598RangeAdditionII solution = new No598RangeAdditionII();
        int[][] ops = new int[][]{{2, 2}, {3, 3}};
        System.out.println(solution.maxCount(3, 3, ops));
    }
}
