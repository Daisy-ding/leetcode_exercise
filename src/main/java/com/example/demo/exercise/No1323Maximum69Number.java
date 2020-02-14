package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/20 11:23 下午
 */
public class No1323Maximum69Number {
    public int maximum69Number(int num) {
        String numStr = String.valueOf(num);
        int first6Index = -1;
        for (int i = 0; i < numStr.length(); ++i) {
            if (numStr.charAt(i) == '6') {
                first6Index = i;
                break;
            }
        }
        if (first6Index == -1) {
            return num;
        }
        char[] chars = numStr.toCharArray();
        chars[first6Index] = '9';
        return Integer.valueOf(new String(chars));
    }
}
