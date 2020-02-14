package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/8 11:39 上午
 */
public class No167TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; ++i) {
            int j = i + 1;
            while (j < numbers.length) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
                if (numbers[i] + numbers[j] > target) {
                    break;
                }
                j++;
            }
        }
        return new int[]{0, 0};
    }
}
