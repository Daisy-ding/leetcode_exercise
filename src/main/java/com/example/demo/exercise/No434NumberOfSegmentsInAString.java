package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/29 11:30 下午
 */
public class No434NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                result++;
            }
        }
        return result;
    }
}
