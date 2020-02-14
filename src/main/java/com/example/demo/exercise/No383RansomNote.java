package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yubang
 * @date 2019/12/8 5:04 下午
 */
public class No383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        for (char c : magazine.toCharArray()) {
            if (countMap.containsKey(c)) {
                int count = countMap.get(c);
                if (count > 0) {
                    countMap.put(c, countMap.get(c) - 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }
}
