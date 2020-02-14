package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/21 12:31 上午
 */
public class No1010PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] map = new int[60];
        for (int i = 0; i < time.length; ++i) {
            int rest = time[i] % 60;
            if (rest == 0) {
                rest = 60;
            }
            int value = map[60 - rest];
            count += value;
            if (rest == 60) {
                rest = 0;
            }
            map[rest]++;
        }
        return count;
    }
}
