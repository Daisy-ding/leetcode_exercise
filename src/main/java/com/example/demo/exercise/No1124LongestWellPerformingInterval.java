package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang
 * @date 2020/1/26 11:44 下午
 */
public class No1124LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        for (int i = 0; i < hours.length; ++i) {
            hours[i] = hours[i] > 8 ? 1 : -1;
        }
        int[] scores = new int[hours.length + 1];
        scores[0] = 0;
        for (int i = 1; i < scores.length; ++i) {
            scores[i] = scores[i - 1] + hours[i - 1];
        }
        //单调递减栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < scores.length; ++i) {
            if (stack.isEmpty() || scores[stack.peek()] > scores[i]) {
                stack.push(i);
            }
        }
        int result = 0;
        for (int i = scores.length - 1; i >= 0; --i) {
            if (scores[i] > scores[stack.peek()]) {
                result = Math.max(result, i - stack.peek());
                stack.pop();
                i++;
                if (stack.isEmpty()) {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No1124LongestWellPerformingInterval solution = new No1124LongestWellPerformingInterval();
        int[] hours = {6, 6, 9};
        System.out.println(solution.longestWPI(hours));
    }
}
