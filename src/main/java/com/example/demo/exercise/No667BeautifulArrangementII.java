package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yubang
 * @date 2020/1/4 2:59 下午
 */
public class No667BeautifulArrangementII {
    private int n;
    private int k;
    private boolean[] marked;
    private int[] results;
    private boolean found;

    public int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        int left = 1;
        int right = n;
        int i = 0;
        while (true) {
            if (i < k) {
                arr[i++] = left++;
            } else {
                break;
            }
            if (i < k) {
                arr[i++] = right--;
            } else {
                break;
            }
        }
        if (k % 2 == 1) {
            for (int j = k; j < arr.length; ++j) {
                arr[j] = left++;
            }
        } else {
            for (int j = k; j < arr.length; ++j) {
                arr[j] = right--;
            }
        }
        return arr;
    }

    public int[] constructArrayBruteForce(int n, int k) {
        this.n = n;
        this.k = k;
        marked = new boolean[n + 1];
        results = new int[n];
        dfs(new ArrayList<>());
        return this.results;
    }

    private void dfs(List<Integer> currentList) {
        if (found) {
            return;
        }
        if (currentList.size() == n) {
            Set<Integer> diffSet = new HashSet<>();
            for (int i = 0; i < currentList.size() - 1; ++i) {
                diffSet.add(Math.abs(currentList.get(i) - currentList.get(i + 1)));
            }
            if (diffSet.size() == k) {
                for (int i = 0; i < currentList.size(); ++i) {
                    results[i] = currentList.get(i);
                }
                found = true;
                return;
            } else {
                return;
            }
        }
        for (int i = 1; i <= n; ++i) {
            if (marked[i]) {
                continue;
            }
            marked[i] = true;
            currentList.add(i);
            dfs(currentList);
            currentList.remove(currentList.size() - 1);
            marked[i] = false;
        }
    }

    public static void main(String[] args) {
        No667BeautifulArrangementII solution = new No667BeautifulArrangementII();
        int[] results = solution.constructArray(6, 3);
        for (int result : results) {
            System.out.print(result + " ");
        }
        System.out.println();
    }
}
