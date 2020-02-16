package com.example.demo.exercise;

/**
 * @author yubang.cwt on 2020/2/16
 */
public class No1347MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        if (s.length() != t.length()) {
            return -1;
        }
        int[] sc = new int[26];
        int[] tc = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            sc[s.charAt(i) - 'a']++;
            tc[t.charAt(i) - 'a']++;
        }
        int result = 0;

        for (int i = 0; i < 26; ++i) {
            if (sc[i] < tc[i]) {
                result += tc[i] - sc[i];
            }
        }
        return result;
    }
}
