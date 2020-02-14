package com.example.demo.exercise;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yubang
 * @date 2020/1/26 3:32 下午
 */
public class No1209RemoveAllAdjacentDuplicatesInStringII {
    private class MultiChar {
        char c;
        int count;

        MultiChar(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        if (k <= 0) {
            return "";
        }
        Deque<MultiChar> deque = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) {
                deque.add(new MultiChar(c, 1));
            } else {
                MultiChar last = deque.peekLast();
                if (last.c != c) {
                    deque.add(new MultiChar(c, 1));
                } else {
                    if (last.count >= k - 1) {
                        deque.pollLast();
                    } else {
                        deque.getLast().count = deque.getLast().count + 1;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (MultiChar mc : deque) {
            for (int i = 0; i < mc.count; ++i) {
                stringBuilder.append(mc.c);
            }
        }
        return stringBuilder.toString();
    }
}
