package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/3 11:17 下午
 */
public class No89GrayCode {
    private List<Integer> results = new ArrayList<>();
    private boolean[] marked;
    private int count;

    public List<Integer> grayCode(int n) {
        results.add(0);
        count = (int) Math.pow(2, n);
        marked = new boolean[count];
        marked[0] = false;
        dfs();
        return results;
    }

    private boolean onlyDiffOneDigit(int a, int b) {
        String tempStr = Integer.toBinaryString(a ^ b);
        int count = 0;
        for (char c : tempStr.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count == 1;
    }

    private void dfs() {
        if (results.size() == count) {
            return;
        }
        for (int i = 1; i < count; ++i) {
            if (marked[i]) {
                continue;
            }
            if (onlyDiffOneDigit(i, results.get(results.size() - 1))) {
                marked[i] = true;
                results.add(i);
                dfs();
            }
        }
    }

    public List<Integer> grayCodeFormula(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        for (int binary = 0; binary < 1 << n; binary++) {
            gray.add(binary ^ binary >> 1);
        }
        return gray;
    }
}
