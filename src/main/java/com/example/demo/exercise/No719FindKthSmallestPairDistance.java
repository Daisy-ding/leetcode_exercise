package com.example.demo.exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/20 10:56 下午
 */
public class No719FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                if (i == j) {
                    continue;
                }
                int abs = Math.abs(nums[i] - nums[j]);
                priorityQueue.add(abs);
                if (priorityQueue.size() > k) {
                    priorityQueue.remove(priorityQueue.peek());
                }
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {62, 100, 4};
        No719FindKthSmallestPairDistance solution = new No719FindKthSmallestPairDistance();
        System.out.println(solution.smallestDistancePair(nums, 2));
    }
}
