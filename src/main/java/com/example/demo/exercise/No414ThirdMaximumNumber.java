package com.example.demo.exercise;

import java.util.PriorityQueue;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/13 12:52 上午
 */
public class No414ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (priorityQueue.contains(num)) {
                continue;
            }
            priorityQueue.add(num);
            if (priorityQueue.size() > 3) {
                priorityQueue.remove(priorityQueue.peek());
            }
        }
        if (priorityQueue.size() == 3) {
            return priorityQueue.peek();
        } else {
            while (priorityQueue.size() != 1) {
                priorityQueue.remove(priorityQueue.peek());
            }
            return priorityQueue.peek();
        }
    }
}
