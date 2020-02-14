package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/27 8:52 下午
 */
public class No1016BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; ++i) {
            if (!S.contains(Integer.toString(i, 2))) {
                return false;
            }
        }
        return true;
    }
}
