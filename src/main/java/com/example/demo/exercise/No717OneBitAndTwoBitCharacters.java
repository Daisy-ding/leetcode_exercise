package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 3:45 下午
 */
public class No717OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                if (i == bits.length - 2) {
                    return false;
                } else {
                    i += 2;
                }
            }
        }
        return true;
    }
}
