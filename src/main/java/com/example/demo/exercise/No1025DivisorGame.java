package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/26 10:01 下午
 */
public class No1025DivisorGame {
    public boolean divisorGame(int N) {
        int moves = 0;
        for (int x = 1; x < N; ++x) {
            if (N % x == 0) {
                N = N - x;
                moves++;
                x = 0;
            }
        }
        if (moves % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
