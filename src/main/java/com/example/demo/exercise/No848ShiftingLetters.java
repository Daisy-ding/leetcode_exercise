package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/31 5:22 下午
 */
public class No848ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        int sum = 0;
        for (int shift : shifts) {
            sum = (sum + shift) % 26;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); ++i) {
            int index = S.charAt(i) - 'a';
            stringBuilder.append((char) ((index + sum) % 26 + 'a'));
            sum = Math.floorMod(sum - shifts[i], 26);
        }
        return stringBuilder.toString();
    }
}
