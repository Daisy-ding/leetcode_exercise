package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/8 5:58 下午
 */
public class No447NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Integer, Integer> distanceSquareCount = new LinkedHashMap<>();
            for (int j = 0; j < points.length; ++j) {
                if (i == j) {
                    continue;
                }
                int distanceSquare = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                        + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (distanceSquareCount.containsKey(distanceSquare)) {
                    distanceSquareCount.put(distanceSquare, distanceSquareCount.get(distanceSquare) + 1);
                } else {
                    distanceSquareCount.put(distanceSquare, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : distanceSquareCount.entrySet()) {
                if (entry.getValue() > 1) {
                    result += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }
        return result;
    }
}
