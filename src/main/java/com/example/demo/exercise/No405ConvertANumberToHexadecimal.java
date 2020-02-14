package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/29 3:49 下午
 */
public class No405ConvertANumberToHexadecimal {
    public String toHex(int num) {
        String result = "";
        char[] hexDigits = "0123456789abcdef".toCharArray();
        while (num != 0) {
            int end = num & 15;
            result = hexDigits[end] + result;
            num = num >>> 4;
        }
        if (result.isEmpty()) {
            result = "0";
        }
        return result;
    }
}
