package com.example.demo.exercise;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/1 7:49 下午
 */
public class No349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new LinkedHashSet<>();
        for (int num : nums1) {
            numSet1.add(num);
        }
        Set<Integer> numSet2 = new LinkedHashSet<>();
        for (int num : nums2) {
            numSet2.add(num);
        }
        Set<Integer> resultSet = new LinkedHashSet<>();
        for (Integer num : numSet1) {
            if (numSet2.contains(num)) {
                resultSet.add(num);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (Integer num : resultSet) {
            result[i++] = num;
        }
        return result;
    }
}
