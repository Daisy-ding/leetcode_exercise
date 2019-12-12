package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/11 11:38 下午
 */
public class No66PlusOne {
    public int[] plusOne(int[] digits) {
        int more = 0;
        int i = digits.length - 1;
        while (i >= 0) {
            int digitNumber = (i == digits.length - 1) ? digits[i] + 1 + more :
                    digits[i] + more;
            digits[i] = digitNumber % 10;
            more = digitNumber / 10;
            i--;
        }
        if (more == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = more;
            for (int j = 0; j < digits.length; ++j) {
                result[j + 1] = digits[j];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        No66PlusOne solution = new No66PlusOne();
        int[] inputs = new int[]{1, 2, 3};
        solution.plusOne(inputs);
    }
}
