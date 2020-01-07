package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/7 10:50 下午
 */
public class No1309DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        Stack<Character> stack = new Stack<>();
        int i = s.length() - 1;
        while (i >= 0) {
            char c = s.charAt(i);
            if (c == '#') {
                int number = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                stack.push((char) ('j' + (number - 10)));
                i = i - 3;
            } else {
                stack.push((char) ('a' + (c - '1')));
                i--;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        No1309DecryptStringFromAlphabetToIntegerMapping solution = new No1309DecryptStringFromAlphabetToIntegerMapping();
        System.out.println(solution.freqAlphabets("10#11#12"));

    }
}
