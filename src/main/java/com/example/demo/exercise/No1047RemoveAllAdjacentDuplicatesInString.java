package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/26 8:46 上午
 */
public class No1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        boolean success = false;
        String input = S;
        String output = "";
        while (!success) {
            output = doRemoveDuplicates(input);
            if (output.equals(input) || output.length() == 1) {
                success = true;
            } else {
                input = output;
            }
        }
        return output;
    }

    public String doRemoveDuplicates(String S) {
        if (S.length() == 1) {
            return S;
        }
        boolean[] remove = new boolean[S.length()];
        int i = 0, j = i + 1;
        while (i < S.length() && j < S.length()) {
            if (S.charAt(i) != S.charAt(j)) {
                i++;
                j++;
            } else {
                remove[i] = true;
                remove[j] = true;
                i = i + 2;
                j = j + 2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < S.length(); ++k) {
            if (!remove[k]) {
                stringBuilder.append(S.charAt(k));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        No1047RemoveAllAdjacentDuplicatesInString solution = new No1047RemoveAllAdjacentDuplicatesInString();
        System.out.println(solution.removeDuplicates("aaaaaaaaa"));
    }
}
