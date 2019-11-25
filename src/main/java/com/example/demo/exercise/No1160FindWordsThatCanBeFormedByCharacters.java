package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 5:05 下午
 */
public class No1160FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int aIndex = (int) 'a';
        int[] charContainer = new int[26];
        for (char c : chars.toCharArray()) {
            charContainer[(int) c - aIndex]++;
        }
        int result = 0;
        out:
        for (String word : words) {
            int[] copy = Arrays.copyOf(charContainer, 26);
            for (char c : word.toCharArray()) {
                if (copy[(int) c - aIndex] > 0) {
                    copy[(int) c - aIndex]--;
                } else {
                    continue out;
                }
            }
            result += word.length();
        }
        return result;
    }
}
