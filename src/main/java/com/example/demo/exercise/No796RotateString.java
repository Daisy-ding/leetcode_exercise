package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/10 12:27 上午
 */
public class No796RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            return true;
        }
        int n = A.length();
        for (int i = 0; i < n; ++i) {
            if (A.charAt(i) == B.charAt(0)) {
                boolean find = true;
                for (int j = 1; j < n; ++j) {
                    if (A.charAt((i + j) % n) != B.charAt(j)) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    return true;
                }
            }
        }
        return false;
    }
}
