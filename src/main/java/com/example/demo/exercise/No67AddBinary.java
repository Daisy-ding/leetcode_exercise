package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/22 9:02 上午
 */
public class No67AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean lastDigitHasPromote = false;
        while (i >= 0 || j >= 0) {
            int digitResult = lastDigitHasPromote ? 1 : 0;
            lastDigitHasPromote = false;
            if (i >= 0) {
                if (a.charAt(i) == '1') {
                    digitResult++;
                    if (digitResult == 2) {
                        lastDigitHasPromote = true;
                        digitResult = 0;
                    }
                }
                i--;
            }
            if (j >= 0) {
                if (b.charAt(j) == '1') {
                    digitResult++;
                    if (digitResult == 2) {
                        lastDigitHasPromote = true;
                        digitResult = 0;
                    }
                }
                j--;
            }
            stringBuilder.append(digitResult == 1 ? '1' : '0');
        }
        if (lastDigitHasPromote) {
            stringBuilder.append('1');
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        No67AddBinary no67AddBinary = new No67AddBinary();
        System.out.println(no67AddBinary.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
