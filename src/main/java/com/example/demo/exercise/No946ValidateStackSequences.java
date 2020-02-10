package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/7 12:01 上午
 */
public class No946ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int n = pushed.length;
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < n && j < n) {
            if (stack.isEmpty() || stack.peek() != popped[j]) {
                while (i < n) {
                    if (pushed[i] == popped[j]) {
                        break;
                    }
                    stack.push(pushed[i]);
                    i++;
                }
                if (i == n) {
                    return false;
                }
                i++;
                j++;
            } else {
                stack.pop();
                j++;
            }
        }
        while (j < n) {
            if (stack.pop() != popped[j++]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No946ValidateStackSequences solution = new No946ValidateStackSequences();
        int[] pushed = {1, 2, 3, 4, 5}, poped = {4, 5, 3, 2, 1};
        solution.validateStackSequences(pushed, poped);
    }
}
