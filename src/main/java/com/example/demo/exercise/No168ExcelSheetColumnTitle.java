package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/14 11:31 上午
 */
public class No168ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            stringBuilder.append((char) ((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return stringBuilder.reverse().toString();
    }
}
