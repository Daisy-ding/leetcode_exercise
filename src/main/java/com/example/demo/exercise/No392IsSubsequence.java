package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/19 11:15 下午
 */
public class No392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
            if (i == s.length()) {
                return true;
            }
        }
        return false;
    }
}
