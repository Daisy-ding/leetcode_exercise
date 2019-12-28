package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/28 9:55 下午
 */
public class No686RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        if (A == null || B == null || A.isEmpty() || B.isEmpty()) {
            return -1;
        }
        if (A.length() > B.length()) {
            if (A.contains(B)) {
                return 1;
            } else if ((A + A).contains(B)) {
                return 2;
            } else {
                return -1;
            }
        }
        int firstIndex = B.indexOf(A);
        if (firstIndex == -1) {
            if ((A + A).contains(B)) {
                return 2;
            } else {
                return -1;
            }
        }
        int result = 1;
        int round = (B.length() - firstIndex) / A.length();
        if (round > 1) {
            for (int i = 1; i < round; ++i) {
                String subString = B.substring(firstIndex + i * A.length(), firstIndex + i * A.length() + A.length());
                if (A.equals(subString)) {
                    result++;
                } else {
                    return -1;
                }
            }
        }
        if (firstIndex > 0) {
            String prefix = B.substring(0, firstIndex);
            if (A.lastIndexOf(prefix) + prefix.length() == A.length()) {
                result++;
            } else {
                return -1;
            }
        }
        if (firstIndex + A.length() * round < B.length()) {
            String suffix = B.substring(firstIndex + A.length() * round);
            if (A.indexOf(suffix) == 0) {
                result++;
            } else {
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No686RepeatedStringMatch solution = new No686RepeatedStringMatch();
        System.out.println(solution.repeatedStringMatch("abcd", "bcdab"));
    }
}
