package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 10:08 下午
 */
public class No1002FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> results = new LinkedList<>();
        int aIndex = (int) 'a';
        int[][] charCountMap = new int[A.length][26];
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[i].length(); ++j) {
                int charIndex = (int) A[i].charAt(j);
                charCountMap[i][charIndex - aIndex]++;
            }
        }

        for (int k = 0; k < 26; ++k) {
            boolean hasCommon = true;
            int minCount = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; ++i) {
                int count = charCountMap[i][k];
                if (0 == count) {
                    hasCommon = false;
                    break;
                }
                if (count < minCount) {
                    minCount = count;
                }
            }
            if (hasCommon) {
                for (int i = 0; i < minCount; ++i) {
                    char[] ca = new char[]{(char) (k + aIndex)};
                    results.add(new String(ca));
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        No1002FindCommonCharacters solution = new No1002FindCommonCharacters();
        String[] inputs = new String[]{"cool","lock","cook"};
        List<String> outputs = solution.commonChars(inputs);
        for (String output : outputs) {
            System.out.println(output);
        }
    }
}
