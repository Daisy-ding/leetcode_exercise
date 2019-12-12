package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/11 11:58 下午
 */
public class No599MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> list2Map = new LinkedHashMap<>();
        for (int i = 0; i < list2.length; ++i) {
            list2Map.put(list2[i], i);
        }
        List<String> list = new LinkedList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; ++i) {
            if (!list2Map.containsKey(list1[i])) {
                continue;
            }
            int indexSum = i + list2Map.get(list1[i]);
            if (indexSum < minIndexSum) {
                list.clear();
                list.add(list1[i]);
                minIndexSum = indexSum;
            } else if (indexSum == minIndexSum) {
                list.add(list1[i]);
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;
    }
}
