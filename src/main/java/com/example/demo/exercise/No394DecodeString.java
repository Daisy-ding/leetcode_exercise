package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/31 3:29 下午
 */
public class No394DecodeString {
    public String decodeString(String s) {
        int n = s.length();
        Stack<String> stack = new Stack<>();
        int i = n - 1;
        while (i >= 0) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                StringBuilder sb = new StringBuilder();
                while (i >= 0 && Character.isLetter(s.charAt(i))) {
                    sb.append(s.charAt(i--));
                }
                stack.push(sb.reverse().toString());
            } else if (c == '[') {
                String lastString = "";
                while (!stack.peek().equals("]")) {
                    lastString += stack.pop();
                }
                //Pop "]"
                stack.pop();

                i--;
                StringBuilder timeBuilder = new StringBuilder();
                while (i >= 0 && Character.isDigit(s.charAt(i))) {
                    timeBuilder.append(s.charAt(i--));
                }
                int times = Integer.valueOf(timeBuilder.reverse().toString());
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < times; ++k) {
                    sb.append(lastString);
                }
                stack.push(sb.toString());
            } else if (c == ']') {
                stack.push("]");
                i--;
            }
        }
        StringBuilder resultBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            resultBuilder.append(stack.pop());
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        No394DecodeString solution = new No394DecodeString();
        System.out.println(solution.decodeString("10[a]"));
    }
}
