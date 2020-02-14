package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/15 11:38 下午
 */
public class No229MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0 || nums == null) return list;

        int winner = nums[0];
        int count1 = 1;
        int winner2 = 0;
        int count2 = 1;
        boolean flag = true;

        // loop through to get the winner(s)
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == winner) {
                count1++;
            } else if (flag) {
                winner2 = nums[i];
                flag = false;
            } else if (winner2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                winner = nums[i];
                count1++;
            } else if (count2 == 0) {
                winner2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }


        count1 = 0;
        count2 = 0;
        //reloop again to see if it appears more than n/3 times
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == winner) {
                count1++;
            }
            if (nums[i] == winner2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            list.add(winner);
        }
        if (!flag && count2 > nums.length / 3) {
            list.add(winner2);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {6, 6, 6, 7, 7};
        No229MajorityElementII solution = new No229MajorityElementII();
        List<Integer> results = solution.majorityElement(nums);
        for (Integer result : results) {
            System.out.println(result);
        }
    }
}
