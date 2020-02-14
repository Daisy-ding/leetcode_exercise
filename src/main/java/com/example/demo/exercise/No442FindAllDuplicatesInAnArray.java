package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/12/21 12:46 上午
 */
public class No442FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                results.add(Math.abs(num));
            } else {
                nums[index] *= -1;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        No442FindAllDuplicatesInAnArray solution = new No442FindAllDuplicatesInAnArray();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        solution.findDuplicates(nums);
    }
}
