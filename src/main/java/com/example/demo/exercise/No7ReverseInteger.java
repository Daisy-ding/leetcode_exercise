package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/19 8:39 上午
 */
public class No7ReverseInteger {
    private int reverse(int x) {
        String input = "" + x;
        boolean isNegative = false;
        if (input.charAt(0) == '-') {
            isNegative = true;
            input = input.substring(1);
        }
        byte[] originBytes = input.getBytes();
        byte[] resultBytes = new byte[originBytes.length];
        for (int i = 0; i < originBytes.length; ++i) {
            resultBytes[i] = originBytes[originBytes.length - i - 1];
        }
        String outputInt = new String(resultBytes);
        if (isNegative) {
            outputInt = "-" + outputInt;
        }

        try {
            return Integer.valueOf(outputInt).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{1534236469, -123, 0, 120};
        No7ReverseInteger no7ReverseInteger = new No7ReverseInteger();
        for (int input : inputs) {
            System.out.println(input + " reverse result : " + no7ReverseInteger.reverse(input));
        }
    }
}
