package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/29 9:01 下午
 */
public class No190ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result = result << 1;
            int current = n & 1;
            result = result | current;
            n = n >>> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        No190ReverseBits solution = new No190ReverseBits();
        System.out.println(solution.reverseBits(43261596));
    }
}
