package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/11 11:27 下午
 */
public class No989AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> digitList = new LinkedList<>();
        int i = A.length - 1;
        int more = 0;
        while (i >= 0 && K > 0) {
            int digitNumber = A[i--] + K % 10 + more;
            digitList.add(digitNumber % 10);
            more = digitNumber / 10;
            K = K / 10;
        }
        while (i >= 0) {
            int digitNumber = A[i--] + more;
            digitList.add(digitNumber % 10);
            more = digitNumber / 10;
        }
        while (K > 0) {
            int digitNumber = K % 10 + more;
            digitList.add(digitNumber % 10);
            more = digitNumber / 10;
            K = K / 10;
        }
        if (more > 0) {
            digitList.add(more);
        }
        List<Integer> result = new LinkedList<>();
        for (int j = digitList.size() - 1; j >= 0; --j) {
            result.add(digitList.get(j));
        }
        return result;
    }
}
