package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/31 11:34 下午
 */
public class No605CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
            return n == 0;
        }
        int current = 0;
        while (n > 0) {
            if (current >= flowerbed.length) {
                return false;
            }
            if (flowerbed[current] == 0 && (current == 0 || flowerbed[current - 1] == 0) && (current == flowerbed.length - 1 || flowerbed[current + 1] == 0)) {
                n--;
                current += 2;
            } else {
                current++;
            }
        }
        return true;
    }
}
