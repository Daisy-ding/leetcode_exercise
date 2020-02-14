package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/8 12:05 上午
 */
public class No171ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int number = 0;
        int i = 0;
        int j = s.length() - 1;
        while (j >= 0) {
            number += Math.pow(26, i) * (s.charAt(j) - 'A' + 1);
            j--;
            i++;
        }
        return number;
    }
}
