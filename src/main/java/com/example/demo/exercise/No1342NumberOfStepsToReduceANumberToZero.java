package com.example.demo.exercise;

/**
 * @author yubang.cwt on 2020/2/13
 */
public class No1342NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
        int result = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                num--;
            } else {
                num /= 2;
            }
            result++;
        }
        return result;
    }
}
