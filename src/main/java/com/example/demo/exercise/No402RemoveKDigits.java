package com.example.demo.exercise;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yubang
 * @date 2020/1/26 11:14 下午
 */
public class No402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        Deque<Character> deque = new LinkedList<>();
        int i = 0;
        while (i < num.length()) {
            char c = num.charAt(i);
            if (deque.isEmpty() || deque.peek() <= c || k == 0) {
                deque.push(c);
                i++;
            } else {
                deque.pop();
                k--;
            }
        }
        while (!deque.isEmpty() && deque.peekLast() == '0') {
            deque.pollLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (deque.size() > k) {
            stringBuilder.append(deque.pollLast());
        }
        String result = stringBuilder.toString();
        if (result.isEmpty()) {
            return "0";
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        No402RemoveKDigits solution = new No402RemoveKDigits();
        System.out.println(solution.removeKdigits("112", 1));
    }
}
