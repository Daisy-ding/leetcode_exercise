package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/7 11:22 下午
 */
public class No121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i + 1] > prices[i]) {
                //Buy It
                int max = prices[i + 1];
                int j = i + 1;
                while (j < prices.length - 1) {
                    if (prices[j + 1] > max) {
                        max = prices[j + 1];
                    }
                    j++;
                }
                int profit = max - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        No121BestTimeToBuyAndSellStock solution = new No121BestTimeToBuyAndSellStock();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
    }
}
