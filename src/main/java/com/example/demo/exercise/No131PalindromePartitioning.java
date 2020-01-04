package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/4 9:57 上午
 */
public class No131PalindromePartitioning {
    private List<List<String>> results = new ArrayList<>();
    private String s;

    private boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return results;
        }
        if (s.length() == 1) {
            List<String> sArray = new ArrayList<>();
            sArray.add(s);
            results.add(sArray);
            return results;
        }
        this.s = s;

        dfs(new ArrayList<>(), 0);
        return results;
    }

    private void dfs(List<String> currentList, int index) {
        if (index == s.length()) {
            results.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = index + 1; i <= s.length(); ++i) {
            if (isPalindrome(index, i - 1)) {
                currentList.add(s.substring(index, i));
                dfs(currentList, i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        No131PalindromePartitioning solution = new No131PalindromePartitioning();
        solution.partition("aab");
    }
}
