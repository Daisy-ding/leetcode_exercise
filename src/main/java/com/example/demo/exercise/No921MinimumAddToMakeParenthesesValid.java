package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/6 11:11 下午
 */
public class No921MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                //c == ')'
                if (stack.isEmpty() || stack.pop() != '(') {
                    result++;
                }
            }
        }
        result += stack.size();
        return result;
    }
}
