package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/31 11:06 下午
 */
public class No6ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s.isEmpty()) {
            return s;
        }
        if (numRows <= 1) {
            return s;
        }
        List<List<Character>> results = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            results.add(new LinkedList<>());
        }

        results.get(0).add(s.charAt(0));
        int currentRow = 1;
        int direct = 1;
        for (int i = 1; i < s.length(); ++i) {
            results.get(currentRow).add(s.charAt(i));
            if (currentRow == 0) {
                direct = 1;
            } else if (currentRow == numRows - 1) {
                direct = -1;
            }
            currentRow = currentRow + direct;
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> characters : results) {
            for (Character c : characters) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
