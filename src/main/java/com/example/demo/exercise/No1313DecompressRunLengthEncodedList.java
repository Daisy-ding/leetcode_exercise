package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/15 11:17 下午
 */
public class No1313DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int n = nums.length;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (2 * i + 1 < n) {
            int a = nums[2 * i];
            int b = nums[2 * i + 1];
            for (int j = 0; j < a; ++j) {
                list.add(b);
            }
            i++;
        }
        int[] result = new int[list.size()];
        for (i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;
    }
}
