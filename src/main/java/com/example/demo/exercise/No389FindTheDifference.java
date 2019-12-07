package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/6 3:13 下午
 */
public class No389FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] charCount = new int[26];
        for (char c : tArray) {
            charCount[c - 'a']++;
        }
        for (char c : sArray) {
            charCount[c - 'a']--;
        }
        for (int i = 0; i < 26; ++i) {
            if (charCount[i] == 1) {
                return (char) ('a' + i);
            }
        }
        return 'a';
    }
}
