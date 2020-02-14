package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/28 11:18 下午
 */
public class No1217PlayWithChips {
    public int minCostToMoveChips(int[] chips) {
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < chips.length; ++i) {
            int cost = 0;
            for (int j = 0; j < chips.length; ++j) {
                if (i == j) {
                    continue;
                }
                if (Math.abs(chips[i] - chips[j]) % 2 == 1) {
                    cost++;
                }
            }
            if (cost < minCost) {
                minCost = cost;
            }
        }
        return minCost;
    }
}
