package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/23 11:14 下午
 */
public class No567PermutationInString {
    private boolean countEquals(int[] count1, int[] count2) {
        for (int i = 0; i < 26; ++i) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Count = new int[26];
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (countEquals(s1Count, s2Count)) {
            return true;
        }
        int i = 1;
        while (i <= s2.length() - s1.length()) {
            s2Count[s2.charAt(i - 1) - 'a']--;
            s2Count[s2.charAt(i + s1.length() - 1) - 'a']++;
            if (countEquals(s1Count, s2Count)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
