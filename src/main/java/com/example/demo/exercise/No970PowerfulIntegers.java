package com.example.demo.exercise;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 5:24 下午
 */
public class No970PowerfulIntegers {
    public int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        int result = x;
        for (int i = 1; i < n; ++i) {
            result *= x;
        }
        return result;
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (true) {
            int j = 0;
            int powerSum = power(x, i) + power(y, j);
            if (powerSum > bound) {
                break;
            }
            while (true) {
                powerSum = power(x, i) + power(y, j);
                if (powerSum <= bound) {
                    if (!result.contains(powerSum)) {
                        result.add(powerSum);
                    }
                } else {
                    break;
                }
                if (y == 1) {
                    break;
                }
                j++;
            }
            if (x == 1) {
                break;
            }
            i++;
        }
        result.sort(Integer::compareTo);
        return result;
    }

    public static void main(String[] args) {
        No970PowerfulIntegers solution = new No970PowerfulIntegers();
        System.out.println(Strings.join(solution.powerfulIntegers(1, 2, 1000000), ','));
    }
}
