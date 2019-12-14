package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 3:55 下午
 */
public class No551StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'A') {
                absentCount++;
                if (absentCount > 1) {
                    return false;
                }
            } else if (c == 'L') {
                if (i < s.length() - 2) {
                    if (s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
