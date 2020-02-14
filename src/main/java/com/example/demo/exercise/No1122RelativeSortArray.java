package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yubang
 * @date 2019/11/24 5:42 下午
 */
public class No1122RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> onlyArray1List = new LinkedList<>();
        for (int i : arr2) {
            map.put(i, 0);
        }
        for (int i : arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                onlyArray1List.add(i);
            }
        }

        onlyArray1List.sort(Integer::compareTo);

        int i = 0;
        for (int j = 0; j < arr2.length; ++j) {
            int count = map.get(arr2[j]);
            for (int k = 0; k < count; ++k) {
                arr1[i + k] = arr2[j];
            }
            i += count;
        }
        for (Integer onlyInt : onlyArray1List) {
            arr1[i++] = onlyInt;
        }
        return arr1;
    }

    public static void main(String[] args) {
        No1122RelativeSortArray solution = new No1122RelativeSortArray();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] outputs = solution.relativeSortArray(arr1, arr2);
        for (int i : outputs) {
            System.out.println(i);
        }
    }
}
