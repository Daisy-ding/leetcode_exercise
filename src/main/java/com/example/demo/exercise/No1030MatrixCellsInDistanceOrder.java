package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/26 10:47 下午
 */
public class No1030MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] results = new int[R * C][2];
        Map<Integer, List<String>> distanceMap = new LinkedHashMap<>();
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                int distance = Math.abs(i - r0) + Math.abs(j - c0);
                if (distanceMap.containsKey(distance)) {
                    distanceMap.get(distance).add("" + i + "," + j);
                } else {
                    List<String> temp = new LinkedList<>();
                    temp.add("" + i + "," + j);
                    distanceMap.put(distance, temp);
                }
            }
        }
        List<Integer> sortedKeys = distanceMap.keySet().stream().sorted()
                .collect(Collectors.toList());
        int i = 0;
        for (Integer key : sortedKeys) {
            for (String r : distanceMap.get(key)) {
                String[] rc = r.split(",");
                results[i++] = new int[]{Integer.valueOf(rc[0]), Integer.valueOf(rc[1])};
            }
        }
        return results;
    }

    public static void main(String[] args) {
        No1030MatrixCellsInDistanceOrder solution = new No1030MatrixCellsInDistanceOrder();
        int[][] results = solution.allCellsDistOrder(1, 2, 0, 0);
        for (int[] result : results) {
            System.out.println(result[0] + "," + result[1]);
        }
    }
}
