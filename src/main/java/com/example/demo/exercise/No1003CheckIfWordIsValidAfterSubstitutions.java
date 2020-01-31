package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/31 3:16 下午
 */
public class No1003CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String S) {
        if (S.length() < 3) {
            return false;
        }

        if (S.equals("abc")) {
            return true;
        }

        int firstIndex = S.indexOf("abc");
        if (firstIndex == -1) {
            return false;
        }

        String newString = S.substring(0, firstIndex) + S.substring(firstIndex + 3);
        return isValid(newString);
    }
}
