package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/30 3:40 下午
 */
public class No1103DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] results = new int[num_people];
        int currentDistribute = 1;
        int i = 0;
        while (candies > 0) {
            if (candies > currentDistribute) {
                results[i % num_people] += currentDistribute;
                candies -= currentDistribute;
                currentDistribute++;
            } else {
                results[i % num_people] += candies;
                candies = 0;
            }
            i++;
        }
        return results;
    }

    public static void main(String[] args) {
        No1103DistributeCandiesToPeople solution = new No1103DistributeCandiesToPeople();
        int[] outputs = solution.distributeCandies(7, 4);
        for (int output : outputs) {
            System.out.println(output);
        }
    }
}
