package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/29 4:34 下午
 */
public class No219ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (numIndexMap.containsKey(num)) {
                if (i - numIndexMap.get(num) <= k) {
                    return true;
                } else {
                    numIndexMap.put(num, i);
                }
            } else {
                numIndexMap.put(num, i);
            }
        }
        return false;
    }
}
