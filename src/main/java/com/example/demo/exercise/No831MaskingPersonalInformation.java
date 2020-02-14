package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/26 10:37 下午
 */
public class No831MaskingPersonalInformation {
    private String maskEmail(String email) {
        String[] parts = email.split("@");
        StringBuilder stringBuilder = new StringBuilder();
        String first = parts[0];
        stringBuilder.append(Character.toLowerCase(first.charAt(0)));
        stringBuilder.append("*****");
        stringBuilder.append(Character.toLowerCase(first.charAt(first.length() - 1)));
        String second = parts[1];
        stringBuilder.append('@');
        stringBuilder.append(second.toLowerCase());
        return stringBuilder.toString();
    }

    private String maskPhoneNumber(String phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : phoneNumber.toCharArray()) {
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            }
        }
        String digits = stringBuilder.toString();
        if (digits.length() == 10) {
            return "***-***-" + digits.substring(6);
        } else {
            int countryCodeLen = digits.length() - 10;
            StringBuilder resultStringBuilder = new StringBuilder();
            resultStringBuilder.append('+');
            for (int k = 0; k < countryCodeLen; ++k) {
                resultStringBuilder.append('*');
            }
            resultStringBuilder.append("-***-***-" + digits.substring(digits.length() - 4));
            return resultStringBuilder.toString();
        }
    }

    public String maskPII(String S) {
        if (S.indexOf('@') >= 0) {
            return maskEmail(S);
        } else {
            return maskPhoneNumber(S);
        }
    }
}
