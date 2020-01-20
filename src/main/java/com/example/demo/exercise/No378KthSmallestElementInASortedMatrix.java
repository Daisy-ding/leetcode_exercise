package com.example.demo.exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/20 10:35 下午
 */
public class No378KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                priorityQueue.add(matrix[i][j]);
                if (priorityQueue.size() > k) {
                    priorityQueue.remove(priorityQueue.peek());
                }
            }
        }
        return priorityQueue.peek();
    }
}
