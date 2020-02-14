package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/24 2:14 下午
 */
public class No942DIStringMatch {
    public int[] diStringMatch(String S) {
        int length = S.length();
        int[] result = new int[length + 1];
        int lower = 0;
        int upper = length;
        int i = 0;
        while (upper > lower) {
            if (S.charAt(i) == 'I') {
                result[i] = lower;
                i++;
                lower++;
            } else {
                result[i] = upper;
                i++;
                upper--;
            }
        }
        result[i] = upper;
        return result;
    }

    public static void main(String[] args) {
        No942DIStringMatch solution = new No942DIStringMatch();
        String[] inputs = new String[]{"IDID", "III", "DDI"};
        for (String input : inputs) {
            int[] result = solution.diStringMatch(input);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < result.length; ++i) {
                builder.append(result[i]);
                if (i != result.length - 1) {
                    builder.append(',');
                }
            }
            System.out.println(builder.toString());
        }
    }
}
