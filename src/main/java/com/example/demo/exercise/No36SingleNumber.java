package com.example.demo.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yubang
 * @date 2019/11/25 11:53 下午
 */
public class No36SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        return (Integer) set.toArray()[0];
    }
}
