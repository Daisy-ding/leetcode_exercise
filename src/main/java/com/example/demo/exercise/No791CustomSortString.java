package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang
 * @date 2020/1/23 8:22 下午
 */
public class No791CustomSortString {
    public String customSortString(String S, String T) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int i = 0; i < S.length(); ++i) {
            charIndexMap.put(S.charAt(i), i);
        }
        List<Character> tcList = new ArrayList<>();
        for (Character c : T.toCharArray()) {
            tcList.add(c);
        }

        tcList.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (charIndexMap.containsKey(o1) && charIndexMap.containsKey(o2)) {
                    return charIndexMap.get(o1) - charIndexMap.get(o2);
                } else if (charIndexMap.containsKey(o1)) {
                    return -1;
                } else if (charIndexMap.containsKey(o2)) {
                    return 1;
                } else {
                    return o1 - o2;
                }
            }
        }
    );
    StringBuilder stringBuilder = new StringBuilder();
        for(
    Character c :tcList)

    {
        stringBuilder.append(c);
    }
        return stringBuilder.toString();
}
}
