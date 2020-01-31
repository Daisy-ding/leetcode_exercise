package com.example.demo.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/31 9:50 下午
 */
public class No966VowelSpellchecker {
    private Set<String> words = new HashSet<>();
    private Map<String, String> wordsCap = new HashMap<>();
    private Map<String, String> wordsVowel = new HashMap<>();

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private String deVowelString(String word) {
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; ++i) {
            if (isVowel(array[i])) {
                array[i] = '*';
            }
        }
        return new String(array);
    }

    private String solve(String query) {
        if (words.contains(query)) {
            return query;
        }
        String lowerQuery = query.toLowerCase();
        if (wordsCap.containsKey(lowerQuery)) {
            return wordsCap.get(lowerQuery);
        }
        String deVowelStr = deVowelString(lowerQuery);
        if (wordsVowel.containsKey(deVowelStr)) {
            return wordsVowel.get(deVowelStr);
        }
        return "";
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        for (String word : wordlist) {
            words.add(word);

            wordsCap.putIfAbsent(word.toLowerCase(), word);

            wordsVowel.putIfAbsent(deVowelString(word.toLowerCase()), word);
        }
        String[] result = new String[queries.length];
        int k = 0;
        for (String query : queries) {
            result[k++] = solve(query);
        }
        return result;
    }
}
