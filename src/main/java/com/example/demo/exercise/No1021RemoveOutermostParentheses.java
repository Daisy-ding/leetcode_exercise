package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/23 8:13 下午
 */
public class No1021RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if (c == '(') {
                if (count++ == 0) {
                    continue;
                }
            } else {
                if (--count == 0) {
                    continue;
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        No1021RemoveOutermostParentheses solution = new No1021RemoveOutermostParentheses();
        String[] inputs = new String[]{
                "(()())(())",
                "(()())(())(()(()))",
                "()()"
        };

        for (String input : inputs) {
            System.out.println(solution.removeOuterParentheses(input));
        }
    }
}
