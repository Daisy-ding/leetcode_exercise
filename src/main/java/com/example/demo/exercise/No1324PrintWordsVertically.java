package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/30 3:19 下午
 */
public class No1324PrintWordsVertically {
    public List<String> printVertically(String s) {
        String[] parts = s.split(" ");

        int maxLen = 0;
        for (String part : parts) {
            maxLen = Math.max(maxLen, part.length());
        }
        List<String> results = new ArrayList<>();
        for (int j = 0; j < maxLen; ++j) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = parts.length - 1;
            while (parts[i].length() <= j) {
                i--;
            }
            while (i >= 0) {
                if (parts[i].length() > j) {
                    stringBuilder.append(parts[i].charAt(j));
                } else {
                    stringBuilder.append(' ');
                }
                i--;
            }
            results.add(stringBuilder.reverse().toString());
        }
        return results;
    }

    public static void main(String[] args) {
        No1324PrintWordsVertically solution = new No1324PrintWordsVertically();
        List<String> results = solution.printVertically("CONTEST IS COMING");
        for (String result : results) {
            System.out.println(result);
        }
    }
}
