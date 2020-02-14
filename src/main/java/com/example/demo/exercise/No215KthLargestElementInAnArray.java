package com.example.demo.exercise;

import java.util.PriorityQueue;

/**
 * @author yubang
 * @date 2019/12/13 12:49 上午
 */
public class No215KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                int first = priorityQueue.peek();
                priorityQueue.remove(first);
            }
        }
        return priorityQueue.peek();
    }
}
