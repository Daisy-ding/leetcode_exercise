package com.example.demo.exercise;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yubang
 * @date 2019/12/12 11:36 下午
 */
public class No997FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) {
            return 1;
        }
        Set<Integer> trustSet = new HashSet<>();
        Map<Integer, Integer> candidateMap = new LinkedHashMap();
        for (int[] pair : trust) {
            trustSet.add(pair[0]);
            if (candidateMap.containsKey(pair[1])) {
                candidateMap.put(pair[1], candidateMap.get(pair[1]) + 1);
            } else {
                candidateMap.put(pair[1], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : candidateMap.entrySet()) {
            if (entry.getValue() == N - 1) {
                if (!trustSet.contains(entry.getKey())) {
                    return entry.getKey();
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        No997FindTheTownJudge solution = new No997FindTheTownJudge();
        int[][] trust = new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(solution.findJudge(4, trust));
    }
}
