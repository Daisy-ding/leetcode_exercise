package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/14 4:35 下午
 */
public class No746MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        } else if (cost.length == 1) {
            return cost[0];
        }
        int n = cost.length;
        int[] T = new int[cost.length + 1];
        for (int i = 2; i <= n; ++i) {
            if (i - 1 >= 0 && i - 2 >= 0) {
                T[i] = Math.min(T[i - 1] + cost[i - 1], T[i - 2] + cost[i - 2]);
            }
            if (i - 1 >= 0 && i - 2 < 0) {
                T[i] = T[i - 1] + cost[i - 1];
            }
        }
        return T[n];
    }

    public static void main(String[] args) {
        int[] cost = {2, 0, 0, 1};
        No746MinCostClimbingStairs solution = new No746MinCostClimbingStairs();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
