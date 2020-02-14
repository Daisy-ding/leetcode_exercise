package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/31 7:34 下午
 */
public class No151ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String[] parts = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; --i) {
            String part = parts[i];
            if (!part.isEmpty()) {
                stringBuilder.append(part).append(" ");
            }
        }
        String result = stringBuilder.toString();
        if (result.isEmpty()) {
            return "";
        }
        return result.substring(0, result.length() - 1);
    }
}
