package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/8 11:23 上午
 */
public class No697DegreeOfAnArray {
    class Degree {
        int count;
        int minIndex;
        int maxIndex;

        public Degree(int count, int minIndex, int maxIndex) {
            this.count = count;
            this.minIndex = minIndex;
            this.maxIndex = maxIndex;
        }

        public int getLength() {
            return maxIndex - minIndex + 1;
        }
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Degree> degreeMap = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (degreeMap.containsKey(num)) {
                Degree degree = degreeMap.get(num);
                degree.count = degree.count + 1;
                degree.maxIndex = i;
            } else {
                degreeMap.put(num, new Degree(1, i, i));
            }
        }
        int maxCount = 0;
        for (Map.Entry<Integer, Degree> entry : degreeMap.entrySet()) {
            if (entry.getValue().count > maxCount) {
                maxCount = entry.getValue().count;
            }
        }

        int minLength = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Degree> entry : degreeMap.entrySet()) {
            if (entry.getValue().count == maxCount) {
                if (entry.getValue().getLength() < minLength) {
                    minLength = entry.getValue().getLength();
                }
            }
        }
        return minLength;
    }
}
