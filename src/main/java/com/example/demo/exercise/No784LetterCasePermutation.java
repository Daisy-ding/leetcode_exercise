package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/30 3:27 下午
 */
public class No784LetterCasePermutation {
    private void letterCasePermutation(String s, int index, List<String> results, String current) {
        if (index == s.length()) {
            results.add(current);
        } else {
            char c = s.charAt(index);
            letterCasePermutation(s, index + 1, results, current + c);
            if (Character.isLetter(c)) {
                letterCasePermutation(s, index + 1, results,
                        current + (Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c)));
            }
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> results = new LinkedList<>();
        letterCasePermutation(S, 0, results, "");
        return results;
    }
}
