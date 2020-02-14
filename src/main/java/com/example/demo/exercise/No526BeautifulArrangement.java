package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/4 2:34 下午
 */
public class No526BeautifulArrangement {
    private int count = 0;
    private int n;
    private boolean[] marked;

    public int countArrangement(int N) {
        if (N <= 0) {
            return 0;
        }
        marked = new boolean[N];
        n = N;
        dfs(new ArrayList<>());
        return count;
    }

    private void dfs(List<Integer> currentList) {
        if (n == currentList.size()) {
            count++;
            return;
        }
        int currentIndex = currentList.size();
        for (int i = 1; i <= n; ++i) {
            if (marked[i - 1]) {
                continue;
            }
            if (i % (currentIndex + 1) == 0 || (currentIndex + 1) % i == 0) {
                currentList.add(i);
                marked[i - 1] = true;
                dfs(currentList);
                currentList.remove(currentList.size() - 1);
                marked[i - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        No526BeautifulArrangement solution = new No526BeautifulArrangement();
        System.out.println(solution.countArrangement(7));
    }
}
