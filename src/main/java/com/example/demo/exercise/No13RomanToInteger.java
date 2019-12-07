package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/6 3:28 下午
 */
public class No13RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> valuesMap = new HashMap<>();
        valuesMap.put('I', 1);
        valuesMap.put('V', 5);
        valuesMap.put('X', 10);
        valuesMap.put('L', 50);
        valuesMap.put('C', 100);
        valuesMap.put('D', 500);
        valuesMap.put('M', 1000);

        int result = 0;
        int i = 0;
        while (i < s.length()) {
            char current = s.charAt(i);
            int currentCount = 1;
            int j = i + 1;
            while (j < s.length()) {
                if (current == s.charAt(j)) {
                    currentCount++;
                    i++;
                    j++;
                } else {
                    break;
                }
            }
            if (j == s.length() || valuesMap.get(current) > valuesMap.get(s.charAt(j))) {
                result += currentCount * valuesMap.get(current);
            } else {
                result -= currentCount * valuesMap.get(current);
            }
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        No13RomanToInteger solution = new No13RomanToInteger();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
