package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/4 10:50 下午
 */
public class No283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length) {
                    if (nums[j] == 0) {
                        j++;
                    } else {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        No283MoveZeroes solution = new No283MoveZeroes();
        int[] inputs = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(inputs);
        for (int i : inputs) {
            System.out.println(i);
        }
    }
}
