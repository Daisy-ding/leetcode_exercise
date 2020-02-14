package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang
 * @date 2020/2/9 10:28 下午
 */
public class No503NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] results = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            results[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return results;
    }
}
