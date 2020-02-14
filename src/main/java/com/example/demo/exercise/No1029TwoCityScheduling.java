package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang
 * @date 2019/12/4 11:41 下午
 */
public class No1029TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length / 2;
        Arrays.sort(costs, (a, b) -> ((a[0] - a[1]) - (b[0] - b[1])));
        int sum = 0;
        for (int i = 0; i < costs.length; ++i) {
            if (i < n) {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }
        return sum;
//        return dpFunction(costs, 0, n, n);
    }

    public int dpFunction(int[][] costs, int i, int city1, int city2) {
        if (i >= costs.length) {
            return 0;
        }
        int city1Sum = 0;
        if (city1 > 0) {
            city1Sum = costs[i][0] + dpFunction(costs, i + 1, city1 - 1, city2);
        }
        int city2Sum = 0;
        if (city2 > 0) {
            city2Sum = costs[i][1] + dpFunction(costs, i + 1, city1, city2 - 1);
        }
        if (city1 > 0 && city2 > 0) {
            return Math.min(city1Sum, city2Sum);
        } else if (city1 > 0) {
            return city1Sum;
        } else {
            return city2Sum;
        }
    }

    public static void main(String[] args) {
        No1029TwoCityScheduling solution = new No1029TwoCityScheduling();
        int[][] costs = new int[][]{
                {555, 594},
                {403, 796},
                {203, 847},
                {292, 885},
                {525, 478},
                {327, 970},
                {297, 483},
                {540, 102},
                {855, 412},
                {174, 684},
                {591, 837},
                {431, 385},
                {107, 740},
                {433, 854},
                {472, 205},
                {862, 439},
                {961, 598},
                {440, 574},
                {716, 156},
                {202, 976},
                {170, 661},
                {661, 823},
                {867, 44},
                {372, 606},
                {8, 281},
                {705, 704},
                {48, 6},
                {909, 266},
                {675, 515},
                {484, 749}};
        System.out.println(solution.twoCitySchedCost(costs));
    }
}
