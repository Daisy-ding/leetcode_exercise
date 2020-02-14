package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/23 10:50 下午
 */
public class No438FindAllAnagramsInAString {
    private boolean countEquals(int[] a, int[] b) {
        for (int i = 0; i < 26; ++i) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int[] sCount = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            char c = s.charAt(i);
            sCount[c - 'a']++;
        }

        List<Integer> result = new LinkedList<>();
        if (countEquals(pCount, sCount)) {
            result.add(0);
        }
        int i = 1;
        while (i <= s.length() - p.length()) {
            sCount[s.charAt(i - 1) - 'a']--;
            sCount[s.charAt(i + p.length() - 1) - 'a']++;
            if (countEquals(pCount, sCount)) {
                result.add(i);
            }
            ++i;
        }
        return result;
    }
}
