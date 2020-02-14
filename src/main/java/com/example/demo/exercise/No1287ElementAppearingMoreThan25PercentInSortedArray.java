package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/24 9:09 下午
 */
public class No1287ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int last = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (last == arr[i]) {
                count++;
                if (count > n * 0.25) {
                    return arr[i];
                }
            } else {
                last = arr[i];
                count = 1;
            }
        }
        return arr[0];
    }
}
