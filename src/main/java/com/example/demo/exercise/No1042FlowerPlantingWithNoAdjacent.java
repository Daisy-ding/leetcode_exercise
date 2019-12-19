package com.example.demo.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/19 11:07 下午
 */
public class No1042FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= N; ++i) {
            graph.put(i, new HashSet<>());
        }
        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] result = new int[N];
        for (int i = 0; i < N; ++i) {
            boolean[] used = new boolean[5];
            for (int abj : graph.get(i + 1)) {
                used[result[abj - 1]] = true;
            }
            for (int j = 1; j <= 4; ++j) {
                if (!used[j]) {
                    result[i] = j;
                }
            }
        }
        return result;
    }
}
