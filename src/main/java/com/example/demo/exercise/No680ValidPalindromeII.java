package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/14 12:28 下午
 */
public class No680ValidPalindromeII {
    private boolean validPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ic = s.charAt(i);
            char jc = s.charAt(j);
            if (ic == jc) {
                i++;
                j--;
            } else {
                break;
            }
        }
        if (i < j) {
            return validPalindrome(s, i + 1, j) || validPalindrome(s, i, j - 1);
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        No680ValidPalindromeII solution = new No680ValidPalindromeII();
        System.out.println(solution.validPalindrome("ebcbbececabbacecbbcbe"));
    }
}
