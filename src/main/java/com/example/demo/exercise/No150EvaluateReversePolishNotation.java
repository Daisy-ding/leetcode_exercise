package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang
 * @date 2020/1/30 11:46 下午
 */
public class No150EvaluateReversePolishNotation {
    private boolean isOp(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

    public int evalRPN(String[] tokens) {
        Stack<String> calculateStack = new Stack<>();
        for (String str : tokens) {
            if (!isOp(str)) {
                calculateStack.push(str);
            } else {
                int second = Integer.valueOf(calculateStack.pop());
                int first = Integer.valueOf(calculateStack.pop());
                int result = 0;
                switch (str) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                    default:
                }
                calculateStack.push("" + result);
            }
        }
        return Integer.valueOf(calculateStack.pop());
    }
}
