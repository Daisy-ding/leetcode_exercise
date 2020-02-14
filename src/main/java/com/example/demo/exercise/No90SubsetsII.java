package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yubang
 * @date 2020/1/2 11:59 下午
 */
public class No90SubsetsII {
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        dfs(countMap, new ArrayList<>());
        results.add(new ArrayList<>());
        return results;
    }

    private void dfs(Map<Integer, Integer> countMap, List<Integer> currentList) {
        List<Integer> newKeys = new ArrayList<>(countMap.keySet());
        newKeys.sort(Integer::compareTo);
        for (Integer key : newKeys) {
            if (countMap.get(key) == 0) {
                continue;
            }
            if (currentList.size() > 0 && key < currentList.get(currentList.size() - 1)) {
                continue;
            }
            List<Integer> newList = new ArrayList<>(currentList);
            newList.add(key);
            results.add(newList);

            countMap.put(key, countMap.get(key) - 1);
            dfs(countMap, newList);
            countMap.put(key, countMap.get(key) + 1);
        }
    }
}
