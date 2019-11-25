package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 5:29 下午
 */
public class No557ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; ++i) {
            for (int j = words[i].length() - 1; j >= 0; --j) {
                stringBuilder.append(words[i].charAt(j));
            }
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
