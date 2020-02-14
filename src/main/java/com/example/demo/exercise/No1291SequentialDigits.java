package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/4 9:40 上午
 */
public class No1291SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        List<Integer> results = new ArrayList<>();
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int i = lowLen; i <= highLen; ++i) {
            for (int j = 0; j <= sample.length() - i; ++j) {
                int value = Integer.parseInt(sample.substring(j, j + i));
                if (value >= low && value <= high) {
                    results.add(value);
                }
            }
        }
        return results;
    }
}
