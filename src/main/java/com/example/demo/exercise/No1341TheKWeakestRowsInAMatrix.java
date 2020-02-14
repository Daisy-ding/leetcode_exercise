package com.example.demo.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yubang
 * @date 2020/2/2 2:34 下午
 */
public class No1341TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer>[] weakDegree = new List[mat.length];
        for (int i = 0; i < mat.length; ++i) {
            int[] m = mat[i];
            int soldierCount = 0;
            for (int num : m) {
                if (num == 1) {
                    soldierCount++;
                }
            }
            weakDegree[i] = Arrays.asList(i, soldierCount);
        }
        Arrays.sort(weakDegree, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(1).equals(o2.get(1))) {
                    return o1.get(0) - o2.get(0);
                }
                return o1.get(1) - o2.get(1);
            }
        });

        int[] result = new int[k];
        int t = 0;
        while (t < k) {
            result[t] = weakDegree[t].get(0);
            t++;
        }
        return result;
    }
}
