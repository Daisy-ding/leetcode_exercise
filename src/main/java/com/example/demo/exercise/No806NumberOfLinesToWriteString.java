package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/28 9:35 下午
 */
public class No806NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int currentWidth = 0;
        int currentLineNumber = 1;
        for (int i = 0; i < S.length(); ++i) {
            int width = widths[S.charAt(i) - 'a'];
            if (currentWidth + width > 100) {
                currentLineNumber++;
                currentWidth = width;
            } else {
                currentWidth += width;
            }
        }
        return new int[]{currentLineNumber, currentWidth};
    }

    public static void main(String[] args) {
        No806NumberOfLinesToWriteString solution = new No806NumberOfLinesToWriteString();
        int[] widths = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] outputs = solution.numberOfLines(widths, "bbbcccdddaaa");
        System.out.println(outputs[0] + "," + outputs[1]);
    }
}
