package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/28 8:53 下午
 */
public class No459RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) {
            return false;
        }
        for (int i = 1; i <= s.length() / 2; ++i) {
            if (s.length() % i != 0) {
                continue;
            }
            int round = s.length() / i;
            boolean found = true;
            for (int j = 1; j < round; ++j) {
                for (int k = 0; k < i; ++k) {
                    if (s.charAt(k) != s.charAt(j * i + k)) {
                        found = false;
                        break;
                    }
                }
                if (!found) {
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No459RepeatedSubstringPattern solution = new No459RepeatedSubstringPattern();
        System.out.println(solution.repeatedSubstringPattern("abcabc"));
    }
}
