package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yubang
 * @date 2020/1/6 10:02 下午
 */
public class No1282GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> peopleGroupSizeMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; ++i) {
            int groupSize = groupSizes[i];
            if (peopleGroupSizeMap.containsKey(groupSize)) {
                peopleGroupSizeMap.get(groupSize).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                peopleGroupSizeMap.put(groupSize, list);
            }
        }
        List<List<Integer>> results = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : peopleGroupSizeMap.entrySet()) {
            if (entry.getKey() == entry.getValue().size()) {
                results.add(entry.getValue());
            } else {
                List<Integer> idList = entry.getValue();
                int round = idList.size() / entry.getKey();
                for (int i = 0; i < round; ++i) {
                    results.add(idList.subList(i * entry.getKey(), (i + 1) * entry.getKey()));
                }
            }
        }
        return results;
    }
}
