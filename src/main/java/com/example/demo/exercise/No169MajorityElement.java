package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yubang
 * @date 2019/12/5 12:32 上午
 */
public class No169MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue().intValue() > n) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
