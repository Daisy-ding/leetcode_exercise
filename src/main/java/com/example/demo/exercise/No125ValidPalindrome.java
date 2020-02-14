package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/14 12:10 下午
 */
public class No125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        int diff = Math.abs('a' - 'A');
        while (i < j) {
            char ic = s.charAt(i);
            if (!Character.isAlphabetic(ic) && !Character.isDigit(ic)) {
                i++;
                continue;
            }
            char jc = s.charAt(j);
            if (!Character.isAlphabetic(jc) && !Character.isDigit(jc)) {
                j--;
                continue;
            }
            if (Character.isAlphabetic(ic) && Character.isAlphabetic(jc)) {
                if (ic != jc && Math.abs(ic - jc) != diff) {
                    return false;
                }
            } else if (Character.isDigit(ic) && Character.isDigit(jc)) {
                if (ic != jc) {
                    return false;
                }
            } else {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        No125ValidPalindrome solution = new No125ValidPalindrome();
        System.out.println(solution.isPalindrome("0P"));
    }
}
