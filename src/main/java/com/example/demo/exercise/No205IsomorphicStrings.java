package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yubang
 * @date 2019/12/29 9:18 下午
 */
public class No205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, List<Integer>> sCharMap = new HashMap<>();
        Map<Character, List<Integer>> tCharMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char sc = s.charAt(i);
            if (sCharMap.containsKey(sc)) {
                sCharMap.get(sc).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                sCharMap.put(sc, indexList);
            }
            char tc = t.charAt(i);
            if (tCharMap.containsKey(tc)) {
                tCharMap.get(tc).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                tCharMap.put(tc, indexList);
            }
        }

        for (List<Integer> sameIndexList : sCharMap.values()) {
            if (sameIndexList.size() == 1) {
                continue;
            }
            char tc = t.charAt(sameIndexList.get(0));
            for (int i = 1; i < sameIndexList.size(); ++i) {
                if (t.charAt(sameIndexList.get(i)) != tc) {
                    return false;
                }
            }
        }

        for (List<Integer> sameIndexList : tCharMap.values()) {
            if (sameIndexList.size() == 1) {
                continue;
            }
            char sc = s.charAt(sameIndexList.get(0));
            for (int i = 1; i < sameIndexList.size(); ++i) {
                if (s.charAt(sameIndexList.get(i)) != sc) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No205IsomorphicStrings solution = new No205IsomorphicStrings();
        System.out.println(solution.isIsomorphic("egg", "add"));
    }
}
