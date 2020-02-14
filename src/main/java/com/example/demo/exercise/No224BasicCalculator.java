package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yubang
 * @date 2020/1/31 12:05 上午
 */
public class No224BasicCalculator {
    private int evaluateExpr(Stack<Object> stack) {
        int result = 0;
        if (!stack.isEmpty()) {
            result = (int) stack.pop();
        }

        while (!stack.isEmpty() && !((char) stack.peek() == ')')) {
            char op = (char) stack.pop();
            if (op == '+') {
                result += (int) stack.pop();
            } else {
                result -= (int) stack.pop();
            }
        }
        return result;
    }

    public int calculate(String s) {
        List<Object> tokens = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i++));
                }
                tokens.add(Integer.valueOf(sb.toString()));
            } else {
                tokens.add(s.charAt(i++));
            }
        }
        Stack<Object> stack = new Stack<>();
        for (i = tokens.size() - 1; i >= 0; --i) {
            Object token = tokens.get(i);
            if (token instanceof Character) {
                if (')' == (char) token) {
                    stack.push(token);
                } else if ('(' == (char) token) {
                    int value = evaluateExpr(stack);
                    stack.pop();
                    stack.push(value);
                } else {
                    stack.push(token);
                }
            } else {
                stack.push(token);
            }
        }
        return evaluateExpr(stack);
    }

    public static void main(String[] args) {
        No224BasicCalculator solution = new No224BasicCalculator();
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
