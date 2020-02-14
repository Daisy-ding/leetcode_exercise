package com.example.demo.exercise;

import java.util.PriorityQueue;

/**
 * @author yubang
 * @date 2019/12/13 12:16 上午
 */
public class No703KthLargestElementInAStream {
    static class KthLargest {
        private PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        private int kth;

        public KthLargest(int k, int[] nums) {
            kth = k;
            for (int num : nums) {
                priorityQueue.add(num);
                if (priorityQueue.size() > k) {
                    Integer first = priorityQueue.peek();
                    priorityQueue.remove(first);
                }
            }
        }

        public int add(int val) {
            if (priorityQueue.size() < kth) {
                priorityQueue.add(val);
                return priorityQueue.peek();
            }
            int first = priorityQueue.peek();
            if (val > first) {
                priorityQueue.add(val);
                priorityQueue.remove(first);
                first = priorityQueue.peek();
                return first;
            } else if (val == first) {
                return val;
            } else {
                return first;
            }
        }
    }

    public static void main(String[] args) {
        int k = 1;
        int[] arr = new int[]{};

        No703KthLargestElementInAStream.KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(-3));   // returns 4
        System.out.println(kthLargest.add(-2));   // returns 5
        System.out.println(kthLargest.add(-4));  // returns 5
        System.out.println(kthLargest.add(0));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}
