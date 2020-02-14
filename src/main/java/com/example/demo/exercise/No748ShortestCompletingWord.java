package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/5 12:17 上午
 */
public class No748ShortestCompletingWord {
    private boolean isContain(String word, int[] license) {
        int[] a = new int[26];
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                a[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                a[c - 'A']++;
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (a[i] < license[i]) {
                return false;
            }
        }
        return true;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] license = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                license[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                license[c - 'A']++;
            }
        }
        String result = null;
        for (String word : words) {
            if (isContain(word, license)) {
                if (result == null || result.length() > word.length()) {
                    result = word;
                }
            }
        }
        return result;
    }
}
