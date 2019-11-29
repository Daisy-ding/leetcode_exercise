package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/28 10:44 下午
 */
public class No476NumberComplement {
    public int findComplement(int num) {
        String binaryString = Integer.toBinaryString(num);
        char[] allOneCharArray = new char[binaryString.length()];
        Arrays.fill(allOneCharArray, '1');
        String allOneString = new String(allOneCharArray);
        return Integer.valueOf(allOneString, 2) ^ num;
    }
}
