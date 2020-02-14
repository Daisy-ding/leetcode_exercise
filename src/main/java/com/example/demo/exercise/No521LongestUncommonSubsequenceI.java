package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/4 2:34 上午
 */
public class No521LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
