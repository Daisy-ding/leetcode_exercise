package com.example.demo.exercise;

import java.util.TreeSet;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/29 12:04 上午
 */
public class No747LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int largestIndex = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (treeSet.size() > 0 && num > treeSet.last()) {
                largestIndex = i;
            }
            treeSet.add(num);
            if (treeSet.size() > 2) {
                treeSet.remove(treeSet.first());
            }
        }
        if (treeSet.size() == 1) {
            return 0;
        }
        int largest = treeSet.last();
        int secondLargest = treeSet.first();
        return largest >= 2 * secondLargest ? largestIndex : -1;
    }

    public static void main(String[] args) {
        No747LargestNumberAtLeastTwiceOfOthers solution = new No747LargestNumberAtLeastTwiceOfOthers();
        int[] nums = {3};
        System.out.println(solution.dominantIndex(nums));
    }
}
