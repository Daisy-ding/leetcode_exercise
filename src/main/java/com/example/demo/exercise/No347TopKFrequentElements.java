package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang
 * @date 2020/1/19 12:39 上午
 */
public class No347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        int[] countArray = new int[countMap.values().size()];
        int t = 0;
        for (int count : countMap.values()) {
            countArray[t++] = count;
        }
        Arrays.sort(countArray);
        int kthCount = countArray[countArray.length - k];
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= kthCount) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
