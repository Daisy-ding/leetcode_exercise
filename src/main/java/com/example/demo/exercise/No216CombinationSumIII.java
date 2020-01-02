package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/3 12:32 上午
 */
public class No216CombinationSumIII {
    private List<List<Integer>> results = new ArrayList<>();
    private boolean[] marked = new boolean[9];

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0) {
            return results;
        }
        dfs(k, n, new ArrayList<>());
        return this.results;
    }

    private void dfs(int k, int n, List<Integer> currentList) {
        if (k == 0) {
            return;
        }
        for (int i = 1; i <= 9; ++i) {
            if (marked[i - 1]) {
                continue;
            }
            if (i > n) {
                continue;
            }
            if (currentList.size() > 0 && i < currentList.get(currentList.size() - 1)) {
                continue;
            }
            if (i == n && k == 1) {
                List<Integer> newList = new ArrayList<>(currentList);
                newList.add(i);
                results.add(newList);
            }
            marked[i - 1] = true;
            List<Integer> newList = new ArrayList<>(currentList);
            newList.add(i);
            dfs(k - 1, n - i, newList);
            marked[i - 1] = false;
        }
    }
}
