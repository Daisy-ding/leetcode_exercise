package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/4 3:13 上午
 */
public class No788RotatedDigits {
    public int rotatedDigits(int N) {
        int result = 0;
        for (int i = 1; i <= N; ++i) {
            String val = Integer.toString(i);
            StringBuilder stringBuilder = new StringBuilder();
            boolean isGoodNumber = true;
            for (char c : val.toCharArray()) {
                if (c == '0' || c == '1' || c == '8') {
                    stringBuilder.append(c);
                } else if (c == '2') {
                    stringBuilder.append('5');
                } else if (c == '5') {
                    stringBuilder.append('2');
                } else if (c == '6') {
                    stringBuilder.append('9');
                } else if (c == '9') {
                    stringBuilder.append('6');
                } else {
                    isGoodNumber = false;
                    break;
                }
            }
            if (isGoodNumber) {
                isGoodNumber = !stringBuilder.toString().equals(val);
            }
            if (isGoodNumber) {
                result++;
            }
        }
        return result;
    }
}
