package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 4:13 下午
 */
public class No119PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        } else if (rowIndex == 1) {
            result.add(1);
            result.add(1);
            return result;
        } else {
            List<Integer> lastList = new ArrayList<>();
            result.add(1);
            result.add(1);
            for (int i = 2; i <= rowIndex; ++i) {
                lastList = result;
                result = new ArrayList<>();
                for (int j = 0; j < i + 1; ++j) {
                    if (j == 0) {
                        result.add(1);
                    } else if (j == i) {
                        result.add(1);
                    } else {
                        result.add(lastList.get(j - 1) + lastList.get(j));
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        No119PascalsTriangleII solution = new No119PascalsTriangleII();
        solution.getRow(3);
    }
}
