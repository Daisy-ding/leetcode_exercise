package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/21 8:39 上午
 */
public class No771JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        for (int i = 0; i < S.length(); ++i) {
            for (int j = 0; j < J.length(); ++j) {
                if (J.charAt(j) == S.charAt(i)) {
                    result++;
                }
            }
        }
        return result;
    }
}
