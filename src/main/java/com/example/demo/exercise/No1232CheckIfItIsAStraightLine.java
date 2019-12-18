package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/18 10:56 下午
 */
public class No1232CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 2) {
            return false;
        } else if (coordinates.length == 2) {
            return true;
        }
        int baseXDiff = coordinates[1][0] - coordinates[0][0];
        int baseYDiff = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; ++i) {
            int xDiff = coordinates[i][0] - coordinates[0][0];
            int yDiff = coordinates[i][1] - coordinates[0][1];
            if (baseXDiff * yDiff != xDiff * baseYDiff) {
                return false;
            }
        }
        return true;
    }
}
