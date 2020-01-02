package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/1 7:31 下午
 */
public class No475Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        if (heaters.length == 1) {
            return Math.max(heaters[0] - houses[0], houses[houses.length - 1] - heaters[0]);
        }
        int radius = Integer.MIN_VALUE;
        for (int i = 0; i < heaters.length; ++i) {
            if (i == 0) {
                //first heater
                int leftRadius = heaters[i] - houses[0];
                radius = Math.max(leftRadius, radius);
            }
            if (i == heaters.length - 1) {
                int rightRadius = houses[houses.length - 1] - heaters[i];
                radius = Math.max(rightRadius, radius);
            }
            if (i != heaters.length - 1) {
                int low = 0;
                int high = houses.length - 1;
                int target = 0;
                while (low < high) {
                    int mid = low + (high - low) / 2;
                    if (houses[mid] == heaters[i]) {
                        target = mid;
                        break;
                    } else if (houses[mid] < heaters[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                for (int j = target; j < houses.length; ++j) {
                    if (houses[j] >= heaters[i + 1]) {
                        break;
                    }
                    if (heaters[i] < houses[j] && houses[j] < heaters[i + 1]) {
                        radius = Math.max(radius, Math.min(houses[j] - heaters[i], heaters[i + 1] - houses[j]));
                    }
                }
            }
        }

        return radius;
    }

    public static void main(String[] args) {
        No475Heaters solution = new No475Heaters();
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        System.out.println(solution.findRadius(houses, heaters));
    }
}
