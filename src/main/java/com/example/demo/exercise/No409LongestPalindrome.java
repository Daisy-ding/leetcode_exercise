package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 1:20 下午
 */
public class No409LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (characterMap.containsKey(c)) {
                characterMap.put(c, characterMap.get(c) + 1);
            } else {
                characterMap.put(c, 1);
            }
        }
        int count = 0;
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                count += entry.getValue();
            } else {
                count += entry.getValue() - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) {
            count++;
        }
        return count;
    }
}
