package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/28 11:22 下午
 */
public class No985SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int basecount = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                basecount += A[i];
            }
        }
        int[] results = new int[queries.length];
        for (int k = 0; k < queries.length; ++k) {
            int[] query = queries[k];
            if (A[query[1]] % 2 == 0) {
                basecount -= A[query[1]];
            }
            A[query[1]] += query[0];
            if (A[query[1]] % 2 == 0) {
                basecount += A[query[1]];
            }
            results[k] = basecount;
        }
        return results;
    }

    public static void main(String[] args) {
        No985SumOfEvenNumbersAfterQueries solution = new No985SumOfEvenNumbersAfterQueries();
        int[] A = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] outputs = solution.sumEvenAfterQueries(A, queries);
        for (int i = 0; i < outputs.length; ++i) {
            System.out.println(outputs[i]);
        }
    }
}
