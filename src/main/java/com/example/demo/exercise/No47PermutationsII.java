package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/3 2:44 下午
 */
public class No47PermutationsII {
    private List<List<Integer>> results = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        dfs(countMap, new ArrayList<>());
        return this.results;
    }

    private void dfs(Map<Integer, Integer> countMap, List<Integer> currentList) {
        if (this.nums.length == currentList.size()) {
            return;
        }
        for (int key : countMap.keySet()) {
            if (countMap.get(key) == 0) {
                continue;
            }
            countMap.put(key, countMap.get(key) - 1);
            List<Integer> newList = new ArrayList<>(currentList);
            newList.add(key);
            if (newList.size() == nums.length) {
                results.add(newList);
            }

            dfs(countMap, newList);
            countMap.put(key, countMap.get(key) + 1);
        }
    }
}
