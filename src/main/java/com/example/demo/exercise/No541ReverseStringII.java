package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/10 12:28 上午
 */
public class No541ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int twoK = 2 * k;
        int round = s.length() % twoK == 0 ? s.length() / twoK : s.length() / twoK + 1;
        if (round == 0) {
            round = 1;
        }
        for (int i = 0; i < round; ++i) {
            int l = 2 * i * k;
            int h = 2 * i * k + k - 1;
            if (h > s.length() - 1) {
                h = s.length() - 1;
            }
            while (l < h) {
                char temp = charArray[l];
                charArray[l] = charArray[h];
                charArray[h] = temp;
                l++;
                h--;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        No541ReverseStringII solution = new No541ReverseStringII();
        System.out.println(solution.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
    }
}
