package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/7 11:03 下午
 */
public class No1071GreatestCommonDivisorOfStrings {
    private boolean isDividedString(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        int sLength = s.length();
        int tLength = t.length();
        if (sLength % tLength != 0) {
            return false;
        }
        int round = sLength / tLength;
        for (int i = 0; i < round; ++i) {
            for (int j = 0; j < t.length(); ++j) {
                if (t.charAt(j) != s.charAt(i * tLength + j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str1;
        }
        int i = str1.length();
        while (i > 0) {
            String subStr = str1.substring(0, i);
            if (isDividedString(str1, subStr) && isDividedString(str2, subStr)) {
                return subStr;
            }
            i--;
        }
        return "";
    }

    public static void main(String[] args) {
        No1071GreatestCommonDivisorOfStrings solution = new No1071GreatestCommonDivisorOfStrings();
        System.out.println(solution.gcdOfStrings("LEEF", "CODE"));
    }
}
