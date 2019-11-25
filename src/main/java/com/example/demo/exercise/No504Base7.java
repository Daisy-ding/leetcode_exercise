package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/21 8:47 上午
 */
public class No504Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -1 * num;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            stringBuilder.append(num % 7);
            num = num / 7;
        }
        String result = stringBuilder.reverse().toString();
        if (isNegative) {
            result = "-" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        No504Base7 no504Base7 = new No504Base7();
        int[] inputs = {100, 0, -100, -7};
        for (int input : inputs) {
            System.out.println(input + ": " + no504Base7.convertToBase7(input));
        }
    }
}
