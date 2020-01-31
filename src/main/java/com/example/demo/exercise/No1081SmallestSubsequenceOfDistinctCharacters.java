package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/31 10:31 下午
 */
public class No1081SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String text) {
        Stack<Character> stack = new Stack<>();
        stack.push(text.charAt(0));
        for (int i = 1; i < text.length(); ++i) {
            char current = text.charAt(i);
            if (stack.contains(current)) {
                continue;
            }
            if (stack.peek() > current) {
                while (!stack.isEmpty() && stack.peek() > current) {
                    char temp = stack.peek();
                    boolean hasLater = false;
                    int j = i + 1;
                    while (j < text.length()) {
                        if (text.charAt(j) == temp) {
                            hasLater = true;
                            break;
                        }
                        j++;
                    }
                    if (hasLater) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(current);
            } else {
                stack.push(current);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No1081SmallestSubsequenceOfDistinctCharacters solution = new No1081SmallestSubsequenceOfDistinctCharacters();
        System.out.println(solution.smallestSubsequence("cdadabcc"));
    }
}
