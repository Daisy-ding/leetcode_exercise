package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/3 3:07 下午
 */
public class No60PermutationSequence {
    private boolean[] marked;
    private int count = 0;
    private int n;
    private int k;
    private String result = "";

    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return "";
        }
        this.n = n;
        this.k = k;
        marked = new boolean[n];
        dfs("");
        return this.result;
    }

    private void dfs(String currentString) {
        if (currentString.length() == n || count >= k) {
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (marked[i - 1]) {
                continue;
            }
            marked[i - 1] = true;
            String newString = currentString + i;
            if (newString.length() == n) {
                count++;
                if (count == k) {
                    result = newString;
                    return;
                }
            }
            dfs(newString);
            marked[i - 1] = false;
        }
    }
}
