package com.example.demo.exercise;

import java.util.TreeSet;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/25 11:12 下午
 */
public class No821ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        int first = -1, last = -1;
        TreeSet<Integer> targetIndexTreeSet = new TreeSet<>();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if (C == c) {
                if (first == -1) {
                    first = i;
                }
                last = i;
                targetIndexTreeSet.add(i);
            }
        }
        int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == C) {
                result[i] = 0;
            } else {
                Integer floor = targetIndexTreeSet.floor(i);
                if (null == floor) {
                    result[i] = first - i;
                    continue;
                }
                Integer ceil = targetIndexTreeSet.ceiling(i);
                if (null == ceil) {
                    result[i] = i - last;
                    continue;
                }
                int min = Math.min((i - floor), (ceil - i));
                result[i] = min;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No821ShortestDistanceToACharacter solution = new No821ShortestDistanceToACharacter();
        int[] result = solution.shortestToChar("loveleetcode", 'e');
        for (int r : result) {
            System.out.println(r);
        }
    }
}
