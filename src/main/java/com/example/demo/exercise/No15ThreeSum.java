package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/2/1 4:27 下午
 */
public class No15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();

        int i = 0;
        int last = nums[0];
        while (i < nums.length) {
            int current = nums[i];
            if (current > 0) {
                last = nums[i++];
                continue;
            }
            if (i > 0 && current == last) {
                last = nums[i++];
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int result = nums[left] + nums[right] + nums[i];
                if (result == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    results.add(list);

                    if (nums[left] == nums[left + 1]) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                    }

                    if (nums[right] == nums[right - 1]) {
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                    }

                    left++;
                    right--;
                } else if (result < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            last = nums[i++];
        }
        return results;
    }

    public static void main(String[] args) {
        No15ThreeSum solution = new No15ThreeSum();
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> results = solution.threeSum(nums);
        for (List<Integer> result : results) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
