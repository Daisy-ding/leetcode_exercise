package com.example.demo.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yubang
 * @date 2019/12/14 3:30 下午
 */
public class No345ReverseVowelsOfAString {
    private Set<Character> vowelSet = new HashSet<>();

    public String reverseVowels(String s) {
        if (s.length() <= 1) {
            return s;
        }
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('i');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('O');
        vowelSet.add('U');
        vowelSet.add('I');

        int i = 0;
        int j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j) {
            while (!vowelSet.contains(charArray[i]) && i < j) {
                i++;
            }
            while (!vowelSet.contains(charArray[j]) && i < j) {
                j--;
            }
            if (i < j) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            }
        }
        return new String(charArray);
    }
}
