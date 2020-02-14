package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/2 11:15 下午
 */
public class No78Subsets {
    private List<List<Integer>> results = new ArrayList<>();
    private boolean[] marked;

    public List<List<Integer>> subsets(int[] nums) {
        marked = new boolean[nums.length];
        dfs(nums, new ArrayList<>());
        results.add(new ArrayList<>());
        return results;
    }

    private void dfs(int[] nums, List<Integer> currentList) {
        for (int i = 0; i < nums.length; ++i) {
            int key = nums[i];
            if (marked[i]) {
                continue;
            }
            if (currentList.size() > 0 && key < currentList.get(currentList.size() - 1)) {
                continue;
            }
            List<Integer> newList = new ArrayList<>(currentList);
            newList.add(key);
            results.add(newList);

            marked[i] = true;
            dfs(nums, newList);
            marked[i] = false;
        }
    }
}
