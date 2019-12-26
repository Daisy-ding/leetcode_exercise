package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/25 11:36 下午
 */
public class No155MinStack {
    private List<Integer> list;

    public No155MinStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return list.stream().min(Integer::compareTo).get();
    }
}
