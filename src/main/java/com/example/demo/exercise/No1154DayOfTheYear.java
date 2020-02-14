package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/9 1:06 上午
 */
public class No1154DayOfTheYear {
    public int dayOfYear(String date) {
        String[] parts = date.split("-");
        int year = Integer.valueOf(parts[0]);
        int month = Integer.valueOf(parts[1]);
        int day = Integer.valueOf(parts[2]);
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        for (int i = 0; i < month - 1; ++i) {
            res += months[i];
        }
        return res + day + (month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) ? 1 : 0);
    }
}
