package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yubang
 * @date 2019/11/29 11:11 下午
 */
public class No884UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> bucketsA = new LinkedHashMap<>();
        Map<String, Integer> bucketsB = new LinkedHashMap<>();

        String[] aArray = A.split(" ");
        String[] bArray = B.split(" ");
        for (String sa : aArray) {
            if (bucketsA.containsKey(sa)) {
                bucketsA.put(sa, bucketsA.get(sa) + 1);
            } else {
                bucketsA.put(sa, 1);
            }
        }
        for (String sb : bArray) {
            if (bucketsB.containsKey(sb)) {
                bucketsB.put(sb, bucketsB.get(sb) + 1);
            } else {
                bucketsB.put(sb, 1);
            }
        }

        Set<String> resultSet = new LinkedHashSet<>();
        for (Map.Entry<String, Integer> entry : bucketsA.entrySet()) {
            if (entry.getValue() == 1 && !bucketsB.containsKey(entry.getKey())) {
                resultSet.add(entry.getKey());
            }
        }

        for (Map.Entry<String, Integer> entry : bucketsB.entrySet()) {
            if (entry.getValue() == 1 && !bucketsA.containsKey(entry.getKey())) {
                resultSet.add(entry.getKey());
            }
        }

        String[] result = new String[resultSet.size()];
        int i = 0;
        for (String s : resultSet) {
            result[i++] = s;
        }
        return result;
    }
}
