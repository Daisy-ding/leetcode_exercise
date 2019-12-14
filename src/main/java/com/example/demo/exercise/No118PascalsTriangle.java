package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 4:03 下午
 */
public class No118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new LinkedList<>();
        for (int i = 1; i <= numRows; ++i) {
            List<Integer> result = new LinkedList<>();
            if (i == 1) {
                result.add(1);
            } else if (i == 2) {
                result.add(1);
                result.add(1);
            } else {
                for (int j = 0; j < i; ++j) {
                    if (j == 0) {
                        result.add(1);
                    } else if (j == i - 1) {
                        result.add(1);
                    } else {
                        result.add(resultList.get(i - 2).get(j - 1) + resultList.get(i - 2).get(j));
                    }
                }
            }
            resultList.add(result);
        }
        return resultList;
    }
}
