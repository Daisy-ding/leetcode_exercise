package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/20 10:49 下午
 */
public class No373FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0) + o2.get(1) - o1.get(0) - o1.get(1);
            }
        });

        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                priorityQueue.add(list);

                if (priorityQueue.size() > k) {
                    priorityQueue.remove(priorityQueue.peek());
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll());
        }
        return result;
    }
}
