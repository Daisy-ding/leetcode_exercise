package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/3 3:17 下午
 */
public class No77Combinations {
    private List<List<Integer>> results = new ArrayList<>();
    private boolean[] marked;
    private int n;
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) {
            return results;
        }
        marked = new boolean[n];
        this.n = n;
        this.k = k;

        dfs(new ArrayList<>());
        return this.results;
    }

    private void dfs(List<Integer> currentList) {
        if (currentList.size() == k) {
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (marked[i - 1]) {
                continue;
            }
            if (currentList.size() > 0 && i <= currentList.get(currentList.size() - 1)) {
                continue;
            }
            marked[i - 1] = true;
            List<Integer> newList = new ArrayList<>(currentList);
            newList.add(i);
            if (newList.size() == k) {
                results.add(newList);
            }
            dfs(newList);
            marked[i - 1] = false;
        }
    }
}
