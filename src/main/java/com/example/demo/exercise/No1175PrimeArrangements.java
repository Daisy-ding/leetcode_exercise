package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 11:20 上午
 */
public class No1175PrimeArrangements {
    private long factorial(int number, int modular) {
        long result = number;
        for (long i = number - 1; i > 1; --i) {
            result = (result * i) % modular;
        }
        return result;
    }

    public int numPrimeArrangements(int n) {
        List<Integer> primes = new LinkedList<>();
        for (int i = 2; i <= n; ++i) {
            boolean isDivided = false;
            for (int val : primes) {
                if (i % val == 0) {
                    isDivided = true;
                    break;
                }
            }
            if (!isDivided) {
                primes.add(i);
            }
        }

        int modular = 1000000007;
        long primeResult = factorial(primes.size(), modular);
        long nonPrimeResult = factorial(n - primes.size(), modular);
        return (int) (Math.max(1, primeResult) * nonPrimeResult % modular);
    }

    public static void main(String[] args) {
        No1175PrimeArrangements solution = new No1175PrimeArrangements();
        solution.numPrimeArrangements(2);
    }
}
