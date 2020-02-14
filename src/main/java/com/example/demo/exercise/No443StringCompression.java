package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/28 11:13 下午
 */
public class No443StringCompression {
    private String digitString(int num) {
        return Integer.toString(num);
    }

    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        char currentChar = chars[0];
        int currentChartCount = 1;
        int currentChartFirstIndex = 0;
        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == currentChar) {
                currentChartCount++;
            } else {
                //先处理完之前一个char的数据逻辑
                chars[currentChartFirstIndex] = currentChar;
                String digitsStr = digitString(currentChartCount);
                if (currentChartCount > 1) {
                    for (int k = 0; k < digitsStr.length(); ++k) {
                        chars[currentChartFirstIndex + k + 1] = digitsStr.charAt(k);
                    }
                }
                //处理当前新的字符
                currentChar = chars[i];
                currentChartFirstIndex += currentChartCount == 1 ? 1 : 1 + digitsStr.length();
                currentChartCount = 1;
            }
        }
        chars[currentChartFirstIndex] = currentChar;
        String digitsStr = digitString(currentChartCount);
        if (currentChartCount > 1) {
            for (int k = 0; k < digitsStr.length(); ++k) {
                chars[currentChartFirstIndex + k + 1] = digitsStr.charAt(k);
            }
        }
        return currentChartCount == 1 ? currentChartFirstIndex + 1 : currentChartFirstIndex + 1 + digitsStr.length();
    }

    public static void main(String[] args) {
        No443StringCompression solution = new No443StringCompression();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(solution.compress(chars));
    }
}
