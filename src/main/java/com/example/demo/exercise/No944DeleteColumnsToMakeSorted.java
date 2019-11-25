package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 2:58 下午
 */
public class No944DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        int wordLength = A[0].length();
        int result = 0;
        for (int i = 0; i < wordLength; ++i) {
            boolean noDecreasingOrder = true;
            int j = 0;
            while (j < A.length - 1) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    noDecreasingOrder = false;
                    break;
                }
                j++;
            }
            if (!noDecreasingOrder) {
                result++;
            }
        }
        return result;
    }
}
