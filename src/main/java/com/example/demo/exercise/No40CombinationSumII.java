package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yubang
 * @date 2020/1/3 12:18 上午
 */
public class No40CombinationSumII {
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int candidate : candidates) {
            if (countMap.containsKey(candidate)) {
                countMap.put(candidate, countMap.get(candidate) + 1);
            } else {
                countMap.put(candidate, 1);
            }
        }
        dfs(countMap, target, new ArrayList<>());
        return this.results;
    }

    private void dfs(Map<Integer, Integer> countMap, int target, List<Integer> currentList) {
        List<Integer> newKeys = new ArrayList<>(countMap.keySet());
        newKeys.sort(Integer::compareTo);
        for (Integer key : newKeys) {
            if (countMap.get(key) == 0) {
                continue;
            }
            if (currentList.size() > 0 && key < currentList.get(currentList.size() - 1)) {
                continue;
            }
            if (key > target) {
                continue;
            }
            if (target == key) {
                List<Integer> newList = new ArrayList<>(currentList);
                newList.add(key);
                results.add(newList);
            } else {
                // key < target
                List<Integer> newList = new ArrayList<>(currentList);
                newList.add(key);

                countMap.put(key, countMap.get(key) - 1);
                dfs(countMap, target - key, newList);
                countMap.put(key, countMap.get(key) + 1);
            }
        }
    }
}
