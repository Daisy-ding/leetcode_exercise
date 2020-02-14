package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/30 11:51 上午
 */
public class No1332RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = s.length() - 1;
        boolean isPalindromic = true;
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                isPalindromic = false;
                break;
            }
        }
        return isPalindromic ? 1 : 2;
    }
}
