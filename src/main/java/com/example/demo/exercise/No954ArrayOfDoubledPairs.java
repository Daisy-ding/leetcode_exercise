package com.example.demo.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/23 9:52 下午
 */
public class No954ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int a : A) {
            if (countMap.containsKey(a)) {
                countMap.put(a, countMap.get(a) + 1);
            } else {
                countMap.put(a, 1);
            }
        }
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; ++i) {
            B[i] = A[i];
        }
        Arrays.sort(B, Comparator.comparingInt(Math::abs));
        for (int b : B) {
            if (countMap.get(b) == 0) {
                continue;
            }
            if (countMap.getOrDefault(2 * b, 0) <= 0) {
                return false;
            }
            countMap.put(b, countMap.get(b) - 1);
            countMap.put(2 * b, countMap.get(2 * b) - 1);
        }
        return true;
    }
}
