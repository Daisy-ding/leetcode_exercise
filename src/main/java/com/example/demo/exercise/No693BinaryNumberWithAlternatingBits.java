package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/30 5:08 下午
 */
public class No693BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No693BinaryNumberWithAlternatingBits solution = new No693BinaryNumberWithAlternatingBits();
        int[] inputs = new int[]{5, 7, 11, 10};
        for (int input : inputs) {
            System.out.println(solution.hasAlternatingBits(input));
        }
    }
}
