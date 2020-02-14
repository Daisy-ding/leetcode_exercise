package com.example.demo.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yubang
 * @date 2019/11/23 1:22 上午
 */
public class No720LongestWordInDictionary {
    public String longestWord(String[] words) {
        if (words.length == 0) {
            return "";
        }
        String result = "";
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            wordsSet.add(word);
        }
        for (String word : wordsSet) {
            if (word.isEmpty()) {
                continue;
            }
            boolean isCandidate = true;
            int length = word.length();
            for (int i = 1; i < length; ++i) {
                String subString = word.substring(0, i);
                if (!wordsSet.contains(subString)) {
                    isCandidate = false;
                    break;
                }
            }
            if (isCandidate) {
                if (word.length() > result.length()) {
                    result = word;
                } else if (word.length() == result.length()) {
                    if (word.compareTo(result) < 0) {
                        result = word;
                    }
                }
            }
        }
        return result;
    }
}
