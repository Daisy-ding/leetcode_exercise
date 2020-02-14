package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/11/23 9:24 下午
 */
public class No728SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new LinkedList<>();
        for (int i = left; i <= right; ++i) {
            String s = "" + i;
            boolean dividingNumber = true;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    dividingNumber = false;
                    break;
                }
                int number = (int) c - 48;
                if (i % number != 0) {
                    dividingNumber = false;
                    break;
                }
            }
            if (dividingNumber) {
                result.add(i);
            }
        }
        return result;
    }
}
