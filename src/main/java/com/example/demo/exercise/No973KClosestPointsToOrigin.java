package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/19 12:37 上午
 */
public class No973KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dist = new int[N];

        for (int i = 0; i < N; ++i) {
            int[] point = points[i];
            int distanceSquare = point[0] * point[0] + point[1] * point[1];
            dist[i] = distanceSquare;
        }
        Arrays.sort(dist);

        int distK = dist[K - 1];

        int[][] result = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i) {
            int[] point = points[i];
            int distanceSquare = point[0] * point[0] + point[1] * point[1];
            if (distanceSquare <= distK) {
                result[t++] = points[i];
            }
        }
        return result;
    }
}
