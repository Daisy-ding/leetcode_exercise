package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/23 9:15 下午
 */
public class No657RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int h = 0, v = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                h++;
            } else if (c == 'D') {
                h--;
            } else if (c == 'L') {
                v--;
            } else if (c == 'R') {
                v++;
            }
        }
        return h == 0 && v == 0;
    }
}
