package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/23 8:52 下午
 */
public class No916WordSubsets {
    private int[] count(String str) {
        int[] result = new int[26];
        for (char c : str.toCharArray()) {
            result[c - 'a']++;
        }
        return result;
    }

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = new int[26];
        for (String b : B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i) {
                bmax[i] = Math.max(bCount[i], bmax[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (String a : A) {
            int[] aCount = count(a);
            boolean hit = true;
            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < bmax[i]) {
                    hit = false;
                    break;
                }
            }
            if (hit) {
                result.add(a);
            }
        }
        return result;
    }
}
