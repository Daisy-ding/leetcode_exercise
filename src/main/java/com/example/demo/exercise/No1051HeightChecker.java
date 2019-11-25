package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 3:15 下午
 */
public class No1051HeightChecker {
    public int heightChecker(int[] heights) {
        int result = 0;
        if (heights.length == 0 || heights.length == 1) {
            return result;
        }

        int[] sortHeights = new int[heights.length];
        for (int i = 0; i < heights.length; ++i) {
            sortHeights[i] = heights[i];
        }
        Arrays.sort(sortHeights);

        for (int i = 0; i < heights.length; ++i) {
            if (heights[i] != sortHeights[i]) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No1051HeightChecker solution = new No1051HeightChecker();
        int[] inputs = new int[]{1, 1, 4, 2, 1, 3};
        System.out.println(solution.heightChecker(inputs));
    }
}
