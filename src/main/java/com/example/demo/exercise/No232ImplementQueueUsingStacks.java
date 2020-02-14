package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang
 * @date 2019/12/29 4:20 下午
 */
public class No232ImplementQueueUsingStacks {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /**
     * Initialize your data structure here.
     */
    public No232ImplementQueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (s1.isEmpty()) {
            s1.push(x);
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return s1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return s1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.empty();
    }
}
