package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang
 * @date 2020/1/31 9:00 下午
 */
public class No49GroupAnagrams {
    private String featureString(String str) {
        int[] counts = new int[26];
        for (char c : str.toCharArray()) {
            counts[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            if (i == 25) {
                sb.append(counts[i]);
            } else {
                sb.append(counts[i]).append('-');
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            String featureStr = featureString(str);
            if (!groupMap.containsKey(featureStr)) {
                groupMap.put(featureStr, new LinkedList<>());
            }
            groupMap.get(featureStr).add(str);
        }
        List<List<String>> results = new ArrayList<>(groupMap.values());
        return results;
    }
}
