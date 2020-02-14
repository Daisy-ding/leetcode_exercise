package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang
 * @date 2020/1/26 12:54 上午
 */
public class No1190ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        char[] array = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == '(') {
                stack.push(i);
            } else if (array[i] == ')') {
                reverse(array, stack.pop() + 1, i - 1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != '(' && array[i] != ')') {
                stringBuilder.append(array[i]);
            }
        }
        return stringBuilder.toString();
    }

    private void reverse(char[] arr, int left, int right) {
        while (right > left) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            right--;
            left++;
        }
    }
}