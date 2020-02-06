package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/4 10:08 下午
 */
public class No930BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] sums = new int[A.length + 1];
        for (int i = 0; i < A.length; ++i) {
            sums[i + 1] = sums[i] + A[i];
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        for (int sum : sums) {
            result += countMap.getOrDefault(sum, 0);
            countMap.put(sum + S, countMap.getOrDefault(sum + S, 0) + 1);
        }
        return result;
    }
}
