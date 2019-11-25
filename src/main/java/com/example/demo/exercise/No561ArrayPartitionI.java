package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 10:05 下午
 */
public class No561ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            int min = Math.min(nums[i], nums[i + 1]);
            sum += min;
        }
        return sum;
    }

    public static void main(String[] args) {
        No561ArrayPartitionI solution = new No561ArrayPartitionI();
        int[] inputs = new int[]{1, 4, 3, 2};
        System.out.println(solution.arrayPairSum(inputs));
    }
}
