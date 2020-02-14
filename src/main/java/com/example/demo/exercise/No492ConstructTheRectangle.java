package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/14 5:11 下午
 */
public class No492ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int base = (int) Math.sqrt(area);
        if (base * base == area) {
            return new int[]{base, base};
        }
        int W = base;
        int L = base + 1;
        while (W * L != area) {
            if (W * L > area) {
                W--;
            } else {
                L++;
            }
        }
        return new int[]{L, W};
    }
}
