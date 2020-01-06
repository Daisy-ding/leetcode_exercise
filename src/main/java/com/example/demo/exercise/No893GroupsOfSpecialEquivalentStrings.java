package com.example.demo.exercise;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/27 11:01 下午
 */
public class No893GroupsOfSpecialEquivalentStrings {
    private String specialEquiv(String a) {
        if (a.length() == 0) {
            return "";
        }
        int aIndex = (int) 'a';
        int[] oddCounts = new int[26];
        int[] evenCounts = new int[26];
        for (int i = 0; i < a.length(); ++i) {
            char ca = a.charAt(i);
            if (i % 2 == 0) {
                evenCounts[(int) ca - aIndex]++;
            } else {
                oddCounts[(int) ca - aIndex]++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            if (oddCounts[i] > 0) {
                stringBuilder.append(oddCounts[i]).append((char) (i + aIndex));
            }
        }
        stringBuilder.append(',');
        for (int i = 0; i < 26; ++i) {
            if (evenCounts[i] > 0) {
                stringBuilder.append(evenCounts[i]).append((char) (i + aIndex));
            }
        }
        return stringBuilder.toString();
    }

    public int numSpecialEquivGroups(String[] A) {
        Set<String> group = new LinkedHashSet<>();
        for (String s : A) {
            group.add(specialEquiv(s));
        }
        return group.size();
    }

    public static void main(String[] args) {
        No893GroupsOfSpecialEquivalentStrings solution = new No893GroupsOfSpecialEquivalentStrings();
        String[] inputs = new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"};
        System.out.println(solution.numSpecialEquivGroups(inputs));
    }
}
