package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/19 11:35 下午
 */
public class No844BackspaceStringCompare {
    private String realString(String input) {
        String result = "";
        for (char c : input.toCharArray()) {
            if (c == '#') {
                if (!result.isEmpty()) {
                    result = result.substring(0, result.length() - 1);
                }
            } else {
                result += c;
            }
        }
        return result;
    }

    public boolean backspaceCompare(String S, String T) {
        String rs = realString(S);
        String rt = realString(T);
        return rs.equals(rt);
    }
}
