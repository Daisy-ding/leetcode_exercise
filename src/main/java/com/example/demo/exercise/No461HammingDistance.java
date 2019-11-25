package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 9:53 下午
 */
public class No461HammingDistance {
    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        String s = Integer.toBinaryString(r);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
