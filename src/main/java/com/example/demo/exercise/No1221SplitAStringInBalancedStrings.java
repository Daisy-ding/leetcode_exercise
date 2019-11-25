package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 7:19 下午
 */
public class No1221SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int i = 0;
        int result = 0;
        while (i < s.length()) {
            int j = i + 1;
            int lastRCount = 0;
            int lastLCount = 0;
            char ci = s.charAt(i);
            if (ci == 'L') {
                lastLCount++;
            } else {
                lastRCount++;
            }
            while (j < s.length()) {
                char cj = s.charAt(j);
                if (cj == 'L') {
                    lastLCount++;
                } else {
                    lastRCount++;
                }
                if (lastLCount == lastRCount) {
                    result++;
                    break;
                }
                j++;
            }
            i = j + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        No1221SplitAStringInBalancedStrings solution = new No1221SplitAStringInBalancedStrings();
        String[] inputs = new String[]{
                "RLRRLLRLRL",
                "RLLLLRRRLR",
                "LLLLRRRR",
                "RLRRRLLRLL"
        };
        for (String input : inputs) {
            System.out.println(solution.balancedStringSplit(input));
        }
    }
}
