package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/6 10:25 下午
 */
public class No763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndexBucket = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            int c = S.charAt(i);
            lastIndexBucket[c - 'a'] = i;
        }

        int j = 0;
        int lastIndex = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, lastIndexBucket[S.charAt(i) - 'a']);
            if (i == j) {
                result.add(i - lastIndex + 1);
                lastIndex = i + 1;
            }
        }
        return result;
    }
}
