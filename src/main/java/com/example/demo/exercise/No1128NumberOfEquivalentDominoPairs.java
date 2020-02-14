package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/26 11:30 下午
 */
public class No1128NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] buckets = new int[100];
        for (int[] domino : dominoes) {
            if (domino[0] <= domino[1]) {
                buckets[domino[0] * 10 + domino[1]]++;
            } else {
                buckets[domino[1] * 10 + domino[0]]++;
            }
        }
        int result = 0;
        for (int i = 1; i <= 9; ++i) {
            for (int j = 1; j <= 9; ++j) {
                int count = buckets[i * 10 + j];
                if (count >= 2) {
                    result += count * (count - 1) / 2;
                }
            }
        }
        return result;
    }
}
