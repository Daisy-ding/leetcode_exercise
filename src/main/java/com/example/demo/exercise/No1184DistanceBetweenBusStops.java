package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 5:46 下午
 */
public class No1184DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        int n = distance.length;
        int sum1 = 0, sum2 = 0;
        if (start < destination) {
            for (int i = start; i < destination; ++i) {
                sum1 += distance[i];
            }
            for (int i = destination; i < start + n; ++i) {
                sum2 += distance[i % n];
            }
            return sum1 <= sum2 ? sum1 : sum2;
        } else {
            for (int i = start; i < destination + n; ++i) {
                sum1 += distance[i % n];
            }
            for (int i = destination; i < start; ++i) {
                sum2 += distance[i];
            }
            return sum1 <= sum2 ? sum1 : sum2;
        }
    }

    public static void main(String[] args) {
        No1184DistanceBetweenBusStops solution = new No1184DistanceBetweenBusStops();
        int[] distance = {1, 2, 3, 4};
        System.out.println(solution.distanceBetweenBusStops(distance, 0, 3));
    }
}
