package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/29 11:48 下午
 */
public class No762PrimeNumberOfSetBitsInBinaryRepresentation {
    private boolean isPrime(int input) {
        if (1 == input) {
            return false;
        }
        if (2 == input) {
            return true;
        }
        for (int i = 2; i < input; ++i) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int i = L; i <= R; ++i) {
            String binaryStr = Integer.toBinaryString(i);
            int oneCount = 0;
            for (char c : binaryStr.toCharArray()) {
                if (c == '1') {
                    oneCount++;
                }
            }
            if (isPrime(oneCount)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No762PrimeNumberOfSetBitsInBinaryRepresentation solution = new No762PrimeNumberOfSetBitsInBinaryRepresentation();
        System.out.println(solution.countPrimeSetBits(244, 269));
    }
}
