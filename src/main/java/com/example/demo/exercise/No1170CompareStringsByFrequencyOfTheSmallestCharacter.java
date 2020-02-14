package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/30 5:02 下午
 */
public class No1170CompareStringsByFrequencyOfTheSmallestCharacter {
    private int f(String word) {
        int minC = 'z';
        int minCCount = 0;
        for (char c : word.toCharArray()) {
            if (c < minC) {
                minC = c;
                minCCount = 1;
            } else if (c == minC) {
                minCCount++;
            }
        }
        return minCCount;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsF = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            wordsF[i] = f(words[i]);
        }
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int frequency = f(queries[i]);
            int count = 0;
            for (int fm : wordsF) {
                if (fm > frequency) {
                    count++;
                }
            }
            results[i] = count;
        }
        return results;
    }
}
