package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/2/1 1:48 下午
 */
public class No43MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        List<Integer> result = new ArrayList<>();
        for (int i = num2.length() - 1; i >= 0; --i) {
            int lastCary = 0;
            int index = num2.length() - 1 - i;
            for (int j = num1.length() - 1; j >= 0; --j) {
                int lastDigit = result.size() > index ? result.get(index) : 0;
                int localResult = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + lastDigit + lastCary;

                if (result.size() > index) {
                    result.set(index, localResult % 10);
                } else {
                    result.add(localResult % 10);
                }
                lastCary = localResult / 10;
                index++;
            }
            while (lastCary > 0) {
                int lastDigit = result.size() > index ? result.get(index) : 0;
                int localResult = lastDigit + lastCary;
                if (result.size() > index) {
                    result.set(index, localResult % 10);
                } else {
                    result.add(localResult % 10);
                }
                lastCary = localResult / 10;
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; --i) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No43MultiplyStrings solution = new No43MultiplyStrings();
        System.out.println(solution.multiply("999", "999"));
    }
}
