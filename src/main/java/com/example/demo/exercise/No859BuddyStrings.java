package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/12/28 10:41 下午
 */
public class No859BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() < 2) {
            return false;
        }
        if (A.length() != B.length()) {
            return false;
        }
        List<Integer> unEqualIndexList = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                unEqualIndexList.add(i);
                if (unEqualIndexList.size() > 2) {
                    return false;
                }
            }
        }
        if (unEqualIndexList.size() == 1) {
            return false;
        } else if (unEqualIndexList.size() == 2) {
            int firstIndex = unEqualIndexList.get(0);
            int secondIndex = unEqualIndexList.get(1);
            if (A.charAt(firstIndex) == B.charAt(secondIndex) && A.charAt(secondIndex) == B.charAt(firstIndex)) {
                return true;
            } else {
                return false;
            }
        } else {
            int[] bucket = new int[26];
            for (char c : A.toCharArray()) {
                bucket[c - 'a']++;
                if (bucket[c - 'a'] >= 2) {
                    return true;
                }
            }
            return false;
        }
    }
}
