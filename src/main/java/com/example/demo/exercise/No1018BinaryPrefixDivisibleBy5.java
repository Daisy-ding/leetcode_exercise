package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/19 11:42 下午
 */
public class No1018BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> results = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < A.length; ++i) {
            results.add((2 * last + A[i]) % 5 == 0);
            last = (2 * last + A[i]) % 5;
        }
        return results;
    }
}
