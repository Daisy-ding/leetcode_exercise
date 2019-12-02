package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/2 11:56 下午
 */
public class No824GoatLatin {
    private char[] vowelChars = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    private boolean isVowel(char c) {
        for (char vowelChar : vowelChars) {
            if (c == vowelChar) {
                return true;
            }
        }
        return false;
    }

    private String latin(String s, int index) {
        StringBuilder stringBuilder = new StringBuilder();
        if (isVowel(s.charAt(0))) {
            stringBuilder.append(s)
                    .append("ma");
        } else {
            stringBuilder.append(s.substring(1))
                    .append(s.charAt(0))
                    .append("ma");
        }
        for (int i = 0; i <= index; ++i) {
            stringBuilder.append('a');
        }
        return stringBuilder.toString();
    }

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            if (i != words.length - 1) {
                stringBuilder.append(latin(words[i], i))
                        .append(' ');
            } else {
                stringBuilder.append(latin(words[i], i));
            }
        }
        return stringBuilder.toString();
    }
}
