package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/29 10:46 下午
 */
public class No525ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countIndexMap = new HashMap<>();
        int maxLen = 0;
        int count = 0;
        countIndexMap.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            count += (nums[i] == 1) ? 1 : -1;
            if (countIndexMap.containsKey(count)) {
                maxLen = Math.max(maxLen, i - countIndexMap.get(count));
            } else {
                countIndexMap.put(count, i);
            }
        }
        return maxLen;
    }
}
