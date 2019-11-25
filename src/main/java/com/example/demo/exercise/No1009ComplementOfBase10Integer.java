package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/20 8:50 上午
 */
public class No1009ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        String byteString = Integer.toBinaryString(N);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < byteString.length(); ++i) {
            char c = byteString.charAt(i);
            if (c == '0') {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return Integer.valueOf(stringBuilder.toString(), 2);
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{5, 7, 10};
        No1009ComplementOfBase10Integer no1009ComplementOfBase10Integer = new No1009ComplementOfBase10Integer();
        for (int input : inputs) {
            System.out.println(input + ": " + no1009ComplementOfBase10Integer.bitwiseComplement(input));
        }
    }
}
