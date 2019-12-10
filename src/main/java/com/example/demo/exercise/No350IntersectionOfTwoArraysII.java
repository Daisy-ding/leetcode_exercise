package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/9 12:25 上午
 */
public class No350IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int num : nums1) {
            if (nums1Map.containsKey(num)) {
                nums1Map.put(num, nums1Map.get(num) + 1);
            } else {
                nums1Map.put(num, 1);
            }
        }

        Map<Integer, Integer> intersectionMap = new HashMap<>();
        for (int num : nums2) {
            if (nums1Map.containsKey(num)) {
                if (intersectionMap.containsKey(num)) {
                    intersectionMap.put(num, intersectionMap.get(num) + 1);
                } else {
                    intersectionMap.put(num, 1);
                }
            }
        }

        List<Integer> intersectionList = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : intersectionMap.entrySet()) {
            int count = Math.min(entry.getValue(), nums1Map.get(entry.getKey()));
            for (int i = 0; i < count; ++i) {
                intersectionList.add(entry.getKey());
            }
        }

        int[] results = new int[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); ++i) {
            results[i] = intersectionList.get(i);
        }
        return results;
    }
}
