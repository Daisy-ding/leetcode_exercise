package com.example.demo.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang.cwt on 2020/2/13
 */
public class No1331RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] results = Arrays.copyOf(arr, arr.length);
        Arrays.sort(results);
        Map<Integer, Integer> rankMap = new HashMap<>();

        int rank = 1;
        for (int i = 0; i < results.length; ++i) {
            if (rankMap.containsKey(results[i])) {
                continue;
            }
            rankMap.put(results[i], rank++);
        }

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        No1331RankTransformOfAnArray solution = new No1331RankTransformOfAnArray();
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        solution.arrayRankTransform(arr);
    }
}
