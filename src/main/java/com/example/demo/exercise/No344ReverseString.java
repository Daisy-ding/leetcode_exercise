package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/25 10:34 下午
 */
public class No344ReverseString {
    public void reverseString(char[] s) {
        int length = s.length;
        if (length == 0 || length == 1) {
            return;
        }
        char temp;
        for (int i = 0; i < length / 2; ++i) {
            temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }
    }
}
