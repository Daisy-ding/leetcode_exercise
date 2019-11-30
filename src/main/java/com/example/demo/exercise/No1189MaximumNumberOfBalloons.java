package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/29 11:24 下午
 */
public class No1189MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] characterCount = new int[26];
        for (char c : text.toCharArray()) {
            characterCount[c - 'a']++;
        }
        int result = Integer.MAX_VALUE;
        int countB = characterCount['b' - 'a'];
        if (countB < result) {
            result = countB;
        }
        int countA = characterCount[0];
        if (countA < result) {
            result = countA;
        }
        int countL = characterCount['l' - 'a'] / 2;
        if (countL < result) {
            result = countL;
        }
        int countO = characterCount['o' - 'a'] / 2;
        if (countO < result) {
            result = countO;
        }
        int countN = characterCount['n' - 'a'];
        if (countN < result) {
            result = countN;
        }
        return result;
    }
}
