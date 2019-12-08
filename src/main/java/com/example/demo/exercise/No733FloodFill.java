package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/8 10:48 上午
 */
public class No733FloodFill {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int height = image.length;
        int weight = image[0].length;

        List<Point> floodPoints = new LinkedList<>();
        floodPoints.add(new Point(sr, sc));
        int oldColor = image[sr][sc];
        while (!floodPoints.isEmpty()) {
            List<Point> newAddedPoints = new LinkedList<>();
            for (Point point : floodPoints) {
                image[point.x][point.y] = newColor;
                Point upPoint = new Point(point.x - 1, point.y);
                if (point.x - 1 >= 0 && image[upPoint.x][upPoint.y] == oldColor && image[upPoint.x][upPoint.y] != newColor) {
                    newAddedPoints.add(upPoint);
                    image[upPoint.x][upPoint.y] = newColor;
                }
                Point downPoint = new Point(point.x + 1, point.y);
                if (point.x + 1 < height && image[downPoint.x][downPoint.y] == oldColor && image[downPoint.x][downPoint.y] != newColor) {
                    newAddedPoints.add(downPoint);
                    image[downPoint.x][downPoint.y] = newColor;
                }
                Point leftPoint = new Point(point.x, point.y - 1);
                if (point.y - 1 >= 0 && image[leftPoint.x][leftPoint.y] == oldColor && image[leftPoint.x][leftPoint.y] != newColor) {
                    newAddedPoints.add(leftPoint);
                    image[leftPoint.x][leftPoint.y] = newColor;
                }
                Point rightPoint = new Point(point.x, point.y + 1);
                if (point.y + 1 < weight && image[rightPoint.x][rightPoint.y] == oldColor && image[rightPoint.x][rightPoint.y] != newColor) {
                    newAddedPoints.add(rightPoint);
                    image[rightPoint.x][rightPoint.y] = newColor;
                }
            }
            floodPoints = newAddedPoints;
        }
        return image;
    }

    public static void main(String[] args) {
        No733FloodFill solution = new No733FloodFill();
        int[][] image = new int[][]{{0, 0, 0}, {0, 0, 0}};
        int[][] newImage = solution.floodFill(image, 0, 0, 2);
        for (int[] row : newImage) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
