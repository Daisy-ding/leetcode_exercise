package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yubang
 * @date 2019/12/8 5:20 下午
 */
public class No387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> characterIndexMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (characterIndexMap.containsKey(c)) {
                characterIndexMap.put(c, -1);
            } else {
                characterIndexMap.put(c, i);
            }
        }
        for (Map.Entry<Character, Integer> entry : characterIndexMap.entrySet()) {
            if (entry.getValue() != -1) {
                return entry.getValue();
            }
        }
        return -1;
    }
}
