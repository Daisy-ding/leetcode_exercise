package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/26 11:54 下午
 */
public class No14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String firstStr = strs[0];
        int i = 0;
        while (i < firstStr.length()) {
            char c = firstStr.charAt(i);
            boolean isSame = true;
            for (int j = 1; j < strs.length; ++j) {
                if (!(strs[j].length() > i && strs[j].charAt(i) == c)) {
                    isSame = false;
                }
            }
            if (isSame) {
                stringBuilder.append(c);
                i++;
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
