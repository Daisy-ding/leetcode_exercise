package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/11 11:04 下午
 */
public class No415AddStrings {
    public String addStrings(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length()) + 1;
        char[] resultString = new char[length];
        int k = length - 1;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int more = 0;
        while (i >= 0 && j >= 0) {
            int kNum = (num1.charAt(i--) - '0') + (num2.charAt(j--) - '0') + more;
            resultString[k--] = (char) ('0' + kNum % 10);
            more = kNum / 10;
        }
        while (i >= 0) {
            int kNum = (num1.charAt(i--) - '0') + more;
            resultString[k--] = (char) ('0' + kNum % 10);
            more = kNum / 10;
        }
        while (j >= 0) {
            int kNum = (num2.charAt(j--) - '0') + more;
            resultString[k--] = (char) ('0' + kNum % 10);
            more = kNum / 10;
        }
        if (more > 0) {
            resultString[k] = (char) ('0' + more);
        } else {
            resultString[k] = '0';
        }
        return more > 0 ? new String(resultString) : new String(resultString).substring(1);
    }

    public static void main(String[] args) {
        No415AddStrings solution = new No415AddStrings();
        System.out.println(solution.addStrings("0", "9"));
    }
}
