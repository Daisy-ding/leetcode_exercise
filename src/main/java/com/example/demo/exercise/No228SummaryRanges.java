package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/24 9:15 下午
 */
public class No228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();
        Integer start = null;
        Integer end = null;
        for (int i = 0; i < nums.length; ++i) {
            if (start == null) {
                start = nums[i];
                end = start;
            } else {
                if (nums[i] == end + 1) {
                    end = nums[i];
                } else {
                    String range = start.equals(end) ? "" + start : "" + start + "->" + end;
                    results.add(range);
                    start = nums[i];
                    end = start;
                }
            }
        }
        if (start != null) {
            String range = start.equals(end) ? "" + start : "" + start + "->" + end;
            results.add(range);
        }
        return results;
    }
}
