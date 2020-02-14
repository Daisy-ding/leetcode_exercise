package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang
 * @date 2020/1/26 9:56 下午
 */
public class No890FindAndReplacePattern {
    private List<List<Integer>> patternArray(String word) {
        Map<Character, List<Integer>> patternMap = new HashMap<>();
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!patternMap.containsKey(c)) {
                patternMap.put(c, new ArrayList<>());
            }
            patternMap.get(c).add(i);
        }
        List<List<Integer>> patternArray = new LinkedList<>(patternMap.values());
        patternArray.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.size() == o2.size()) {
                    for (int k = 0; k < o1.size(); ++k) {
                        int i1 = o1.get(k);
                        int i2 = o2.get(k);
                        if (i1 == i2) {
                            continue;
                        } else {
                            return i1 - i2;
                        }
                    }
                    return 0;
                } else {
                    return o2.size() - o1.size();
                }
            }
        });
        return patternArray;
    }

    private boolean matches(List<List<Integer>> pattern1, List<List<Integer>> pattern2) {
        if (pattern1.size() != pattern2.size()) {
            return false;
        }
        for (int i = 0; i < pattern1.size(); ++i) {
            List<Integer> indexList1 = pattern1.get(i);
            List<Integer> indexList2 = pattern2.get(i);
            if (indexList1.size() != indexList2.size()) {
                return false;
            }

            if (!indexList1.containsAll(indexList2)) {
                return false;
            }
        }
        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<List<Integer>> patternCount = patternArray(pattern);
        List<String> results = new LinkedList<>();
        for (String word : words) {
            List<List<Integer>> p = patternArray(word);
            if (matches(patternCount, p)) {
                results.add(word);
            }
        }
        return results;
    }
}
