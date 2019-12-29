package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/29 9:41 下午
 */
public class No290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strList = str.split(" ");
        if (pattern.length() != strList.length) {
            return false;
        }

        Map<Character, List<Integer>> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);
            if (patternMap.containsKey(c)) {
                patternMap.get(c).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                patternMap.put(c, indexList);
            }
        }

        Map<String, List<Integer>> strMap = new HashMap<>();
        for (int i = 0; i < strList.length; ++i) {
            String s = strList[i];
            if (strMap.containsKey(s)) {
                strMap.get(s).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                strMap.put(s, indexList);
            }
        }

        for (List<Integer> sameIndexList : patternMap.values()) {
            if (sameIndexList.size() == 1) {
                continue;
            }
            String s = strList[sameIndexList.get(0)];
            for (int i = 1; i < sameIndexList.size(); ++i) {
                if (!strList[sameIndexList.get(i)].equals(s)) {
                    return false;
                }
            }
        }

        for (List<Integer> sameIndexList : strMap.values()) {
            if (sameIndexList.size() == 1) {
                continue;
            }
            char c = pattern.charAt(sameIndexList.get(0));
            for (int i = 1; i < sameIndexList.size(); ++i) {
                if (pattern.charAt(sameIndexList.get(i)) != c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No290WordPattern solution = new No290WordPattern();
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
    }
}
