package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/2 11:06 下午
 */
public class No812LargestTriangleArea {
    private double triangleArea(int[] point1, int[] point2, int[] point3) {
        return Math.abs(point1[0] * point2[1] - point1[0] * point3[1]
                + point2[0] * point3[1] - point2[0] * point1[1]
                + point3[0] * point1[1] - point3[0] * point2[1]) / 2.0;
    }

    public double largestTriangleArea(int[][] points) {
        double max = 0.0;
        for (int i = 0; i < points.length; ++i) {
            for (int j = 0; j < points.length; ++j) {
                for (int k = 0; k < points.length; ++k) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    double area = triangleArea(points[i], points[j], points[k]);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        No812LargestTriangleArea solution = new No812LargestTriangleArea();
        //int[][] points = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        int[][] points = new int[][]{{8, 3}, {5, 6}, {3, 5}};
        System.out.println(solution.largestTriangleArea(points));
    }
}
