package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang
 * @date 2020/1/3 9:59 下午
 */
public class No22GenerateParentheses {
    private List<String> results = new ArrayList<>();
    private Map<Character, Integer> parenthesisMap = new HashMap<>();
    private int n;

    public List<String> generateParenthesis(int n) {
        parenthesisMap.put('(', n);
        parenthesisMap.put(')', n);
        this.n = n;
        dfs("");
        return this.results;
    }

    private void dfs(String currentString) {
        if (currentString.length() == 2 * n) {
            return;
        }
        if (unNormal(currentString)) {
            return;
        }
        for (char c : parenthesisMap.keySet()) {
            if (parenthesisMap.get(c) == 0) {
                continue;
            }
            parenthesisMap.put(c, parenthesisMap.get(c) - 1);
            String newString = currentString + c;
            if (newString.length() == 2 * n && c == ')') {
                results.add(newString);
            }
            dfs(newString);
            parenthesisMap.put(c, parenthesisMap.get(c) + 1);
        }
    }

    private boolean unNormal(String currentString) {
        Stack<Character> stack = new Stack<>();
        for (char c : currentString.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return true;
                }
            }
        }
        return false;
    }
}
