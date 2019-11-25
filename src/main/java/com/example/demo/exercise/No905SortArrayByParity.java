package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 8:55 下午
 */
public class No905SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        while (i < A.length) {
            int iValue = A[i];
            if (iValue % 2 == 1) {
                int j = i + 1;
                while (j < A.length) {
                    int jValue = A[j];
                    if (jValue % 2 == 1) {
                        j++;
                    } else {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        break;
                    }
                }
            }
            i++;
        }
        return A;
    }

    public static void main(String[] args) {
        No905SortArrayByParity solution = new No905SortArrayByParity();
        int[] input = new int[]{3, 1, 2, 4};
        int[] result = solution.sortArrayByParity(input);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; ++i) {
            stringBuilder.append(result[i]);
            if (i != result.length - 1) {
                stringBuilder.append(',');
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
