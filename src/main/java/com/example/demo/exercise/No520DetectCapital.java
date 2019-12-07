package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/8 12:00 上午
 */
public class No520DetectCapital {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capitalCount++;
            }
        }
        if (capitalCount == word.length()) {
            return true;
        }
        if (capitalCount == 0) {
            return true;
        }
        if (capitalCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        return false;
    }
}
