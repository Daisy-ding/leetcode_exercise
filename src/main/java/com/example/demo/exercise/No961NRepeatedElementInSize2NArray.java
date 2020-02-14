package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang
 * @date 2019/11/23 9:10 下午
 */
public class No961NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if (map.containsKey(i)) {
                int count = map.get(i).intValue() + 1;
                if (count >= A.length / 2) {
                    return i;
                }
                map.put(i, count);
            } else {
                map.put(i, 1);
            }
        }
        return 0;
    }
}
