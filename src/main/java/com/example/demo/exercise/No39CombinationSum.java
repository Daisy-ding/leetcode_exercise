package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/3 12:08 上午
 */
public class No39CombinationSum {
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>());
        return this.results;
    }

    private void dfs(int[] candidates, int target, List<Integer> currentList) {
        for (int i = 0; i < candidates.length; ++i) {
            int num = candidates[i];
            if (currentList.size() > 0 && num > currentList.get(currentList.size() - 1)) {
                continue;
            }
            if (num > target) {
                continue;
            }
            if (num == target) {
                List<Integer> newList = new ArrayList<>(currentList);
                newList.add(num);
                results.add(newList);
            } else {
                //num < target
                List<Integer> newList = new ArrayList<>(currentList);
                newList.add(num);
                dfs(candidates, target - num, newList);
            }
        }
    }
}
