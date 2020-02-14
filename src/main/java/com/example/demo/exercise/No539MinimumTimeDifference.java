package com.example.demo.exercise;

import java.util.Arrays;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/27 9:27 下午
 */
public class No539MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int result = Integer.MAX_VALUE;
        int[] times = new int[timePoints.size()];
        int i = 0;
        for (String timePoint : timePoints) {
            String[] parts = timePoint.split(":");
            int time = Integer.valueOf(parts[0]) * 60 + Integer.valueOf(parts[1]);
            times[i++] = time;
        }
        Arrays.sort(times);
        for (i = 0; i < times.length - 1; ++i) {
            result = Math.min(times[i + 1] - times[i], result);
        }
        result = Math.min(times[0] + 1440 - times[times.length - 1], result);
        return result;
    }
}
