package com.example.demo.exercise;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/23 11:53 下午
 */
public class No1249MinimumRemoveToMakeValidParentheses {
    private class CharWithIndex {
        char c;
        int index;

        public CharWithIndex(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public String minRemoveToMakeValid(String s) {
        Set<Integer> toDelete = new HashSet<>();
        Stack<CharWithIndex> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(new CharWithIndex('(', i));
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    toDelete.add(i);
                } else {
                    CharWithIndex ci = stack.peek();
                    if (ci.c == '(') {
                        stack.pop();
                    } else {
                        toDelete.add(i);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            CharWithIndex ci = stack.pop();
            toDelete.add(ci.index);
        }

        char[] newCharArray = new char[s.length() - toDelete.size()];
        int i = 0;
        int j = 0;
        char[] charArray = s.toCharArray();
        while (i < charArray.length && j < newCharArray.length) {
            if (toDelete.contains(i)) {
                i++;
            } else {
                newCharArray[j++] = charArray[i++];
            }
        }
        return new String(newCharArray);
    }
}
