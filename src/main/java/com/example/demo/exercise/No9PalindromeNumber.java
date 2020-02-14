package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/14 11:43 上午
 */
public class No9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
