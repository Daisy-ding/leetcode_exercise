package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 4:03 下午
 */
public class No441ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int level = (int) Math.floor(Math.sqrt(n));
        int total = level * (level + 1) / 2;
        int remain = n - total;
        while (remain > level) {
            level++;
            remain = remain - level;
        }
        return level;
    }

    public static void main(String[] args) {
        No441ArrangingCoins solution = new No441ArrangingCoins();
        int[] inputs = new int[]{1804289383};
        for (int input : inputs) {
            System.out.println(input + " : " + solution.arrangeCoins(input));
        }
    }
}
