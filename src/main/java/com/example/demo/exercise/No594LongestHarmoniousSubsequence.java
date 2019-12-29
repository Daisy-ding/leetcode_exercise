package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/29 11:24 上午
 */
public class No594LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> numsCountMap = new HashMap<>();
        for (int num : nums) {
            if (numsCountMap.containsKey(num)) {
                numsCountMap.put(num, numsCountMap.get(num) + 1);
            } else {
                numsCountMap.put(num, 1);
            }
        }
        int maxCount = 0;
        for (Integer key : numsCountMap.keySet()) {
            if (numsCountMap.containsKey(key + 1)) {
                maxCount = Math.max(maxCount, numsCountMap.get(key) + numsCountMap.get(key + 1));
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        No594LongestHarmoniousSubsequence solution = new No594LongestHarmoniousSubsequence();
        int[] nums = {1, 10, 5, 6, 7, 8, 2, 3, 2, 2, 5, 2, 3, 7, 2, 3, 9, 10};
        System.out.print(solution.findLHS(nums));
    }
}
