package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/4 11:16 上午
 */
public class No306AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        if (n < 3) {
            return false;
        }
        for (int i = 1; i <= n / 2; ++i) {
            String str1 = num.substring(0, i);
            long first = Long.parseLong(str1);
            if (Long.toString(first).length() != str1.length()) {
                continue;
            }
            for (int j = i + 1; j <= i + (n - i) / 2; ++j) {
                String str2 = num.substring(i, j);
                long second = Long.parseLong(str2);
                if (Long.toString(second).length() != str2.length()) {
                    continue;
                }
                if (dfs(num.substring(j), first, second)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(String currentString, long first, long second) {
        if (currentString.isEmpty()) {
            return true;
        }
        long sum = first + second;
        String sumStr = Long.toString(sum);
        int index = currentString.indexOf(sumStr);
        if (index != 0) {
            return false;
        }
        return dfs(currentString.substring(sumStr.length()), second, sum);
    }

    public static void main(String[] args) {
        No306AdditiveNumber solution = new No306AdditiveNumber();
        System.out.println(solution.isAdditiveNumber("11111111111011111111111"));
    }
}
