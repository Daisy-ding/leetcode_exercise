package com.example.demo.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 8:20 下午
 */
public class No1200MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(arr);

        int minDifferent = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; ++i) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDifferent) {
                minDifferent = diff;
            }
        }
        for (int i = 1; i < arr.length; ++i) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDifferent) {
                List<Integer> pairs = new LinkedList<>();
                pairs.add(arr[i - 1]);
                pairs.add(arr[i]);
                results.add(pairs);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        No1200MinimumAbsoluteDifference solution = new No1200MinimumAbsoluteDifference();
        int[] inputs = new int[]{3, 8, -10, 23, 19, -4, -14, 27};
        List<List<Integer>> outputs = solution.minimumAbsDifference(inputs);
        for (List<Integer> output : outputs) {
            System.out.println(output.get(0) + "," + output.get(1));
        }
    }
}
