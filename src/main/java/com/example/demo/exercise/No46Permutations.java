package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/3 2:33 下午
 */
public class No46Permutations {
    private List<List<Integer>> results = new ArrayList<>();
    private boolean[] marked;

    public List<List<Integer>> permute(int[] nums) {
        marked = new boolean[nums.length];
        dfs(nums, new ArrayList<>());
        return this.results;
    }

    private void dfs(int[] nums, List<Integer> currentList) {
        if (currentList.size() == nums.length) {
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (marked[i]) {
                continue;
            }
            marked[i] = true;
            List<Integer> newList = new ArrayList<>(currentList);
            newList.add(nums[i]);
            if (newList.size() == nums.length) {
                results.add(newList);
            }
            dfs(nums, newList);
            marked[i] = false;
        }
    }
}
