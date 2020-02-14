package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/12/18 9:48 下午
 */
public class No830PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> results = new LinkedList<>();
        int startIndex = 0;
        int i = 1;
        int count = 1;
        while (i < S.length()) {
            if (S.charAt(i) == S.charAt(startIndex)) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> result = new LinkedList<>();
                    result.add(startIndex);
                    result.add(startIndex + count - 1);
                    results.add(result);
                }
                startIndex = i;
                count = 1;
            }
            i++;
        }
        if (count >= 3) {
            List<Integer> result = new LinkedList<>();
            result.add(startIndex);
            result.add(startIndex + count - 1);
            results.add(result);
        }
        return results;
    }

    public static void main(String[] args) {
        No830PositionsOfLargeGroups solution = new No830PositionsOfLargeGroups();
        List<List<Integer>> results = solution.largeGroupPositions("abcdddeeeeaabbbcd");
        for (List<Integer> result : results) {
            System.out.println(result.get(0) + "," + result.get(1));
        }
    }
}
