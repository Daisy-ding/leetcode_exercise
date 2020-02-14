package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/30 5:21 下午
 */
public class No1089DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == 0) {
                for (int j = arr.length - 2; j >= i + 1; --j) {
                    arr[j + 1] = arr[j];
                }
                if (i != arr.length - 1) {
                    arr[i + 1] = 0;
                }
                i += 2;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        No1089DuplicateZeros solution = new No1089DuplicateZeros();
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(arr);
        for (int i = 0; i < arr.length; ++i) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println();
    }
}
