package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/16 12:22 上午
 */
public class No792NumberOfMatchingSubsequences {
    private boolean isSubSeq(String S, String word) {
        if (S.length() < word.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < word.length()) {
            if (j >= S.length()) {
                return false;
            }
            if (word.charAt(i) == S.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return true;
    }

    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        for (String word : words) {
            if (isSubSeq(S, word)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"a", "bb", "acd", "ace"};
        String S = "abcde";
        No792NumberOfMatchingSubsequences solution = new No792NumberOfMatchingSubsequences();
        System.out.println(solution.numMatchingSubseq(S, words));
    }
}
