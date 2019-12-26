package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/26 10:21 下午
 */
public class No1295FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            String numStr = Integer.toString(num);
            if (numStr.length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
