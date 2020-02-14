package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang
 * @date 2019/12/24 11:18 下午
 */
public class No819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<Character> punctuationSymbols = new ArrayList<>();
        punctuationSymbols.add('!');
        punctuationSymbols.add('?');
        punctuationSymbols.add('\'');
        punctuationSymbols.add(',');
        punctuationSymbols.add(';');
        punctuationSymbols.add('.');
        char[] arrays = paragraph.toCharArray();
        for (int i = 0; i < arrays.length; ++i) {
            char c = arrays[i];
            if (punctuationSymbols.contains(c)) {
                arrays[i] = ' ';
            } else {
                arrays[i] = Character.toLowerCase(c);
            }
        }

        String[] parts = new String(arrays).split(" ");
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            if (countMap.containsKey(part)) {
                countMap.put(part, countMap.get(part) + 1);
            } else {
                countMap.put(part, 1);
            }
        }
        TreeMap<Integer, List<String>> sortedMap = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (sortedMap.containsKey(entry.getValue())) {
                sortedMap.get(entry.getValue()).add(entry.getKey());
            } else {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                sortedMap.put(entry.getValue(), list);
            }
        }
        List<String> bannedList = new ArrayList<>();
        for (String ban : banned) {
            bannedList.add(ban);
        }
        for (Integer count : sortedMap.descendingKeySet()) {
            List<String> keys = sortedMap.get(count);
            for (String key : keys) {
                if (!bannedList.contains(key)) {
                    return key;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        No819MostCommonWord solution = new No819MostCommonWord();
        String[] banned = {"hit"};
        System.out.println(solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", banned));

    }
}
