package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/7 11:22 下午
 */
public class No122BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        while (i < prices.length - 1) {
            if (prices[i + 1] > prices[i]) {
                //Buy It
                int max = prices[i + 1];
                int j = i + 1;
                while (j < prices.length - 1) {
                    if (prices[j] > prices[j + 1]) {
                        break;
                    }
                    if (prices[j + 1] > max) {
                        max = prices[j + 1];
                    }
                    j++;
                }
                profit += max - prices[i];
                i = j + 1;
            } else {
                i++;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        No122BestTimeToBuyAndSellStockII solution = new No122BestTimeToBuyAndSellStockII();
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution.maxProfit(prices));
    }
}
