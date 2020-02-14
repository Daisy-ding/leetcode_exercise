package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/3 10:44 下午
 */
public class No17LetterCombinationsOfAPhoneNumber {
    private List<String> results = new ArrayList<>();
    private char[][] digitMaps = {{'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    private String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;

        dfs("");
        return this.results;
    }

    private void dfs(String currentString) {
        if (currentString.length() == digits.length()) {
            return;
        }
        char[] digitMap = digitMaps[this.digits.charAt(currentString.length()) - '2'];
        for (char c : digitMap) {
            String newString = currentString + c;
            if (newString.length() == digits.length()) {
                results.add(newString);
            } else {
                dfs(newString);
            }
        }
    }
}
