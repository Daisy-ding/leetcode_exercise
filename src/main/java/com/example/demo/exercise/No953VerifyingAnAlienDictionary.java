package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/4 11:58 下午
 */
public class No953VerifyingAnAlienDictionary {
    public boolean isWordsSorted(String a, String b, int[] charIndex) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (charIndex[a.charAt(i) - 'a'] > charIndex[b.charAt(j) - 'a']) {
                return false;
            } else if (charIndex[a.charAt(i) - 'a'] < charIndex[b.charAt(j) - 'a']) {
                return true;
            } else {
                i++;
                j++;
            }
        }
        if (i == a.length()) {
            return true;
        } else if (i < a.length() && j == b.length()) {
            return false;
        }
        return false;
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] charIndex = new int[26];
        for (int i = 0; i < order.toCharArray().length; ++i) {
            char c = order.toCharArray()[i];
            charIndex[c - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; ++i) {
            if (!isWordsSorted(words[i], words[i + 1], charIndex)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No953VerifyingAnAlienDictionary solution = new No953VerifyingAnAlienDictionary();
        String[] words = new String[]{"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(solution.isAlienSorted(words, order));
    }
}
