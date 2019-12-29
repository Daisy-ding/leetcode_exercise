package com.example.demo.exercise;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/29 4:26 下午
 */
public class No225ImplementStackUsingQueues {
    private Deque<Integer> deque;

    /**
     * Initialize your data structure here.
     */
    public No225ImplementStackUsingQueues() {
        deque = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        deque.addFirst(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return deque.pollFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return deque.peekFirst();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return deque.isEmpty();
    }
}
