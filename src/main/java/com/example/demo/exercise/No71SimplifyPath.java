package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang
 * @date 2020/1/23 11:25 下午
 */
public class No71SimplifyPath {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String part : parts) {
            if (part.isEmpty() || ".".equals(part)) {
                continue;
            }
            if ("..".equals(part)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(part);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        Stack<String> result = new Stack<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!result.isEmpty()) {
            stringBuilder.append("/").append(result.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        No71SimplifyPath solution = new No71SimplifyPath();
        System.out.println(solution.simplifyPath(path));
    }
}
