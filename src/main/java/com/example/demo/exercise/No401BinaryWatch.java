package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/12/29 3:07 下午
 */
public class No401BinaryWatch {
    private int oneBitCount(int num) {
        int result = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                result++;
            }
            num = num / 2;
        }
        return result;
    }

    public List<String> readBinaryWatch(int num) {
        List<String> results = new ArrayList<>();
        for (int hour = 0; hour < 12; ++hour) {
            for (int minute = 0; minute < 60; ++minute) {
                if (oneBitCount(hour) + oneBitCount(minute) == num) {
                    String time = hour + ":" + (minute >= 10 ? "" : "0") + minute;
                    results.add(time);
                }
            }
        }
        return results;
    }
}
