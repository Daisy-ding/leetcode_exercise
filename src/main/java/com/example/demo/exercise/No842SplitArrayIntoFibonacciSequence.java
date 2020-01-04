package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/4 1:06 下午
 */
public class No842SplitArrayIntoFibonacciSequence {
    private List<Integer> results = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String S) {
        int n = S.length();
        if (n < 3) {
            return new ArrayList<>();
        }

        for (int i = 1; i <= n / 2; ++i) {
            String str1 = S.substring(0, i);
            long first = Long.parseLong(str1);
            if (first > Integer.MAX_VALUE) {
                break;
            }
            if (Long.toString(first).length() != str1.length()) {
                continue;
            }
            for (int j = i + 1; j <= i + (n - i) / 2; ++j) {
                String str2 = S.substring(i, j);
                long second = Long.parseLong(str2);
                if (second > Integer.MAX_VALUE) {
                    break;
                }
                if (Long.toString(second).length() != str2.length()) {
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                list.add((int) first);
                list.add((int) second);
                dfs(list, S.substring(j));
                if (results.size() > 0) {
                    return results;
                }
            }
        }
        return results;
    }

    private void dfs(List<Integer> currentList, String currentString) {
        if (currentString.isEmpty()) {
            results = new ArrayList<>(currentList);
            return;
        }
        int size = currentList.size();
        long sum = currentList.get(size - 1) + currentList.get(size - 2);
        if (sum > Integer.MAX_VALUE) {
            return;
        }
        String sumStr = Long.toString(sum);
        int index = currentString.indexOf(sumStr);
        if (index != 0) {
            return;
        }
        currentList.add((int) sum);
        dfs(currentList, currentString.substring(sumStr.length()));
        currentList.remove(currentList.size() - 1);
    }

    public static void main(String[] args) {
        No842SplitArrayIntoFibonacciSequence solution = new No842SplitArrayIntoFibonacciSequence();
        List<Integer> results = solution.splitIntoFibonacci("1101111");
        for (int result : results) {
            System.out.println(result);
        }
    }
}
