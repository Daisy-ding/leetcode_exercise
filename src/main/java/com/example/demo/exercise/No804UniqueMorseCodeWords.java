package com.example.demo.exercise;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 7:33 下午
 */
public class No804UniqueMorseCodeWords {
    private String morseCode(String word) {
        String[] morseChar = new String[]{
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); ++i) {
            int c = (int) word.charAt(i);
            int a = (int) 'a';
            stringBuilder.append(morseChar[c - a]);
        }
        return stringBuilder.toString();
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> uniqueMorseWords = new LinkedHashSet<>();
        for (String word : words) {
            uniqueMorseWords.add(morseCode(word));
        }
        return uniqueMorseWords.size();
    }

    public static void main(String[] args) {
        No804UniqueMorseCodeWords solution = new No804UniqueMorseCodeWords();
        String[] inputs = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(solution.uniqueMorseRepresentations(inputs));
    }
}
