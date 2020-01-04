package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/4 4:30 下午
 */
public class No1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    private int maxLength = 0;
    private List<String> arr;

    public int maxLength(List<String> arr) {
        this.arr = arr;
        dfs(new ArrayList<>(), 0);
        return maxLength;
    }

    private boolean isUnique(List<String> temp) {
        Set<Character> set = new HashSet();
        for (String s : temp) {
            for (char c : s.toCharArray()) {
                if (!set.add(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(List<String> currentList, int currentIndex) {
        if (currentIndex == arr.size()) {
            int count = 0;
            for (String s : currentList) {
                count += s.length();
            }
            maxLength = Math.max(maxLength, count);
        }
        for (int i = currentIndex; i < arr.size(); ++i) {
            currentList.add(arr.get(i));
            if (isUnique(currentList)) {
                dfs(currentList, currentIndex + 1);
                currentList.remove(currentList.size() - 1);
            } else {
                currentList.remove(currentList.size() - 1);
                dfs(currentList, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        No1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters solution = new No1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
        List<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");
        arr.add("e");
        arr.add("f");
        arr.add("g");
        arr.add("h");
        arr.add("i");
        arr.add("j");
        arr.add("k");

        System.out.println(solution.maxLength(arr));
    }
}
