package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/12/5 11:34 下午
 */
public class No448FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                int currentValue = nums[i];
                int index = currentValue - 1;
                while (nums[index] != currentValue) {
                    int nextValue = nums[index];
                    nums[index] = currentValue;
                    index = nextValue - 1;
                    currentValue = nextValue;
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No448FindAllNumbersDisappearedInAnArray solution = new No448FindAllNumbersDisappearedInAnArray();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> outputs = solution.findDisappearedNumbers(nums);
        for (Integer output : outputs) {
            System.out.println(output.intValue());
        }
    }
}
