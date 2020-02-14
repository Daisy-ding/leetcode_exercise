package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/6 2:45 下午
 */
public class No696CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int count = 0;
        char[] charArray = s.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            char startChar = charArray[i];
            int startCharCount = 1;
            int j = i + 1;
            while (j < charArray.length) {
                if (charArray[j] == startChar) {
                    startCharCount++;
                    j++;
                } else {
                    break;
                }
            }
            if (j < charArray.length) {
                char endChar = charArray[j];
                int endCharCount = 1;
                int k = j + 1;
                while (k < charArray.length) {
                    if (charArray[k] == endChar) {
                        endCharCount++;
                        k++;
                    } else {
                        break;
                    }
                }
                if (startCharCount <= endCharCount) {
                    count += startCharCount;
                    i += startCharCount;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No696CountBinarySubstrings solution = new No696CountBinarySubstrings();
        System.out.println(solution.countBinarySubstrings("1010110101101011010110101"));
    }
}
