package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang
 * @date 2020/2/9 10:35 下午
 */
public class No556NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        int source = n;
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 10);
            n = n / 10;
        }
        int[] sourceDigits = new int[stack.size()];
        int t = 0;
        while (!stack.isEmpty()) {
            sourceDigits[t++] = stack.pop();
        }

        for (int i = sourceDigits.length - 1; i >= 1; --i) {
            if (sourceDigits[i] > sourceDigits[i - 1]) {
                int minLargerIndex = i;
                int j = i + 1;
                while (j < sourceDigits.length) {
                    if (sourceDigits[j] > sourceDigits[i - 1] && sourceDigits[j] <= sourceDigits[minLargerIndex]) {
                        minLargerIndex = j;
                    }
                    j++;
                }
                int temp = sourceDigits[minLargerIndex];
                sourceDigits[minLargerIndex] = sourceDigits[i - 1];
                sourceDigits[i - 1] = temp;

                //reverse from i to minLargerIndex
                int left = i;
                int right = sourceDigits.length - 1;
                while (left < right) {
                    temp = sourceDigits[left];
                    sourceDigits[left] = sourceDigits[right];
                    sourceDigits[right] = temp;
                    left++;
                    right--;
                }
                break;
            }
        }
        int result = 0;
        for (int i = 0; i < sourceDigits.length; ++i) {
            result = result * 10 + sourceDigits[i];
            if (result >= Integer.MAX_VALUE / 10 && i != sourceDigits.length - 1) {
                return -1;
            }
        }
        if (result == source) {
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        No556NextGreaterElementIII solution = new No556NextGreaterElementIII();
        System.out.println(solution.nextGreaterElement(1999999999));
    }
}
