package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/30 3:09 下午
 */
public class No868BinaryGap {
    public int binaryGap(int N) {
        String binaryStr = Integer.toBinaryString(N);
        int result = 0;
        int currentOneIndex = binaryStr.indexOf('1');
        if (-1 == currentOneIndex) {
            return 0;
        }
        int i = currentOneIndex + 1;
        while (i < binaryStr.length()) {
            if (binaryStr.charAt(i) == '1') {
                int distance = i - currentOneIndex;
                if (distance > result) {
                    result = distance;
                }
                currentOneIndex = i;
                i++;
            } else {
                i++;
            }
        }
        return result;
    }
}
