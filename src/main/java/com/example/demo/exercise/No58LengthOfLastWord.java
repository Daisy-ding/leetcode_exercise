package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 3:49 下午
 */
public class No58LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int lastWordCount = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                if (lastWordCount > 0) {
                    break;
                }
            } else {
                lastWordCount++;
            }
        }
        return lastWordCount;
    }
}
