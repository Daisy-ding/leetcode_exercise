package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 9:58 下午
 */
public class No852PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int index = 1;
        while (index < A.length - 1) {
            if (A[index] > A[index - 1] && A[index] > A[index + 1]) {
                return index;
            }
            index++;
        }
        return 0;
    }

    public static void main(String[] args) {
        No852PeakIndexInAMountainArray solution = new No852PeakIndexInAMountainArray();
        int[] inputs = new int[]{0, 1, 0};
        System.out.println(solution.peakIndexInMountainArray(inputs));
    }
}
