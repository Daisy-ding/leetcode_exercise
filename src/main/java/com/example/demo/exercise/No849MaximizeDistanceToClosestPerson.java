package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/26 10:55 下午
 */
public class No849MaximizeDistanceToClosestPerson {
    private int maxDistance(List<Integer> seatsIndexList, int index) {
        int left = seatsIndexList.get(0);
        int right = seatsIndexList.get(seatsIndexList.size() - 1);
        if (index < left) {
            return left - index;
        } else if (index > right) {
            return index - right;
        }
        for (int i = 0; i < seatsIndexList.size() - 1; ++i) {
            if (seatsIndexList.get(i) < index && seatsIndexList.get(i + 1) > index) {
                return Math.min(index - seatsIndexList.get(i), seatsIndexList.get(i + 1) - index);
            }
        }
        return 0;
    }

    public int maxDistToClosest(int[] seats) {
        List<Integer> seatsIndexList = new ArrayList<>();
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                seatsIndexList.add(i);
            }
        }
        int result = 0;
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 0) {
                result = Math.max(result, maxDistance(seatsIndexList, i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] seats = {1, 1, 1, 0, 0, 1, 1, 1, 1, 0};
        No849MaximizeDistanceToClosestPerson solution = new No849MaximizeDistanceToClosestPerson();
        System.out.println(solution.maxDistToClosest(seats));
    }
}
