package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 3:20 下午
 */
public class No26RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int result = 1;
        int i = 0;
        int j = i + 1;
        while (i < nums.length) {
            while (j < nums.length) {
                if (nums[i] != nums[j]) {
                    result++;
                    break;
                }
                j++;
            }
            i++;
            if (i == nums.length || j == nums.length) {
                break;
            }
            nums[i] = nums[j];
        }
        return result;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {
        No26RemoveDuplicateFromSortedArray solution = new No26RemoveDuplicateFromSortedArray();
        int[] inputs = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(integerArrayToString(inputs, solution.removeDuplicates(inputs)));
    }
}
