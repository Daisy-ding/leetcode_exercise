package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/29 11:25 下午
 */
public class No1328BreakAPalindrome {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) {
            return "";
        }
        char[] arrays = palindrome.toCharArray();
        for (int i = 0; i < palindrome.length(); ++i) {
            if (palindrome.length() % 2 == 1 && i == palindrome.length() / 2) {
                continue;
            }
            if (arrays[i] != 'a') {
                arrays[i] = 'a';
                return new String(arrays);
            }
        }
        arrays[arrays.length - 1] = 'b';
        return new String(arrays);
    }
}
