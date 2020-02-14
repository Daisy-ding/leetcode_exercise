package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang
 * @date 2020/2/1 11:16 下午
 */
public class No482LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        Stack<Character> stack = new Stack<>();
        for (int i = S.length() - 1; i >= 0; --i) {
            char c = S.charAt(i);
            if (c == '-') {
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        int firstSize = stack.size() % K;
        int round = stack.size() / K;
        int count = firstSize;
        while (count > 0) {
            char current = stack.pop();
            if (Character.isDigit(current)) {
                sb.append(current);
            } else {
                sb.append(Character.toUpperCase(current));
            }
            count--;
        }
        for (int i = 0; i < round; ++i) {
            sb.append('-');
            for (int j = 0; j < K; ++j) {
                char current = stack.pop();
                if (Character.isDigit(current)) {
                    sb.append(current);
                } else {
                    sb.append(Character.toUpperCase(current));
                }
            }
        }
        String result = sb.toString();
        if (result.startsWith("-")) {
            return result.substring(1);
        } else {
            return result;
        }
    }
}
