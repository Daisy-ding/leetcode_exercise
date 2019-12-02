package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/2 10:55 下午
 */
public class No917ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;
        char[] charArray = S.toCharArray();
        while (i < j) {
            char ci = charArray[i];
            char cj = charArray[j];
            boolean isCiLetter = Character.isLetter(ci);
            boolean isCjLetter = Character.isLetter(cj);
            if (isCiLetter && isCjLetter) {
                char temp = ci;
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            } else {
                if (!isCiLetter) {
                    i++;
                }
                if (!isCjLetter) {
                    j--;
                }
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        No917ReverseOnlyLetters solution = new No917ReverseOnlyLetters();
        System.out.println(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
