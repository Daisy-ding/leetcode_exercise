package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/28 10:09 下午
 */
public class No500KeyboardRow {
    private int findRow(char[][] alphabet, char c) {
        if ('A' <= c && 'Z' >= c) {
            c -= ('A' - 'a');
        }
        for (int i = 0; i < alphabet.length; ++i) {
            for (int j = 0; j < alphabet[i].length; ++j) {
                if (alphabet[i][j] == c) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String[] findWords(String[] words) {
        char[][] alphabet = new char[][]{
                {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
        };
        List<String> results = new LinkedList<>();
        for (String word : words) {
            boolean hit = true;
            int row = findRow(alphabet, word.charAt(0));
            for (int j = 1; j < word.length(); ++j) {
                if (findRow(alphabet, word.charAt(j)) != row) {
                    hit = false;
                    break;
                }
            }
            if (hit) {
                results.add(word);
            }
        }
        String[] array = new String[results.size()];
        for (int i = 0; i < results.size(); ++i) {
            array[i] = results.get(i);
        }
        return array;
    }
}
