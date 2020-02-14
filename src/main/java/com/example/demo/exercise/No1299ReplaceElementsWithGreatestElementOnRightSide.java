package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/29 10:08 上午
 */
public class No1299ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            if (i == arr.length - 1) {
                result[i] = -1;
            } else {
                int max = arr[i + 1];
                int j = i + 1;
                while (j < arr.length) {
                    max = Math.max(max, arr[j++]);
                }
                result[i] = max;
            }
        }
        return result;
    }
}
