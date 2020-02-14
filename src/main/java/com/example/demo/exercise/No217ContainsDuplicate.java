package com.example.demo.exercise;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yubang
 * @date 2019/12/5 12:43 上午
 */
public class No217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
