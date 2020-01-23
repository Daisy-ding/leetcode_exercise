package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/19 12:27 上午
 */
public class No743NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (graph.containsKey(edge[0])) {
                graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{edge[1], edge[2]});
                graph.put(edge[0], list);
            }
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        Map<Integer, Integer> dist = new HashMap<>();
        priorityQueue.add(new int[]{K, 0});
        while (!priorityQueue.isEmpty()) {
            int[] info = priorityQueue.poll();
            int node = info[0];
            int d = info[1];
            if (dist.containsKey(node)) {
                continue;
            }
            dist.put(node, d);
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int node2 = edge[0];
                    int d2 = edge[1];
                    if (!dist.containsKey(node2)) {
                        priorityQueue.add(new int[]{node2, d + d2});
                    }
                }
            }
        }
        if (dist.size() != N) {
            return -1;
        }
        int result = 0;
        for (int candidate : dist.values()) {
            result = Math.max(result, candidate);
        }
        return result;
    }
}
