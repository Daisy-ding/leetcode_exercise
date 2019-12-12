package com.example.demo.exercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/11 11:48 下午
 */
public class No506RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int[] sortArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortArray);
        Map<Integer, String> resultMap = new LinkedHashMap<>();
        for (int i = 1; i <= sortArray.length; ++i) {
            if (i == 1) {
                resultMap.put(sortArray[sortArray.length - i], "Gold Medal");
            } else if (i == 2) {
                resultMap.put(sortArray[sortArray.length - i], "Silver Medal");
            } else if (i == 3) {
                resultMap.put(sortArray[sortArray.length - i], "Bronze Medal");
            } else {
                resultMap.put(sortArray[sortArray.length - i], "" + i);
            }
        }
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            result[i] = resultMap.get(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        No506RelativeRanks solution = new No506RelativeRanks();
        int[] inputs = new int[]{5, 4, 3, 2, 1};
        solution.findRelativeRanks(inputs);
    }
}
