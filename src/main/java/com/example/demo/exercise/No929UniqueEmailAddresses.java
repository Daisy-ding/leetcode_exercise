package com.example.demo.exercise;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yubang
 * @date 2019/11/24 3:47 下午
 */
public class No929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> address = new LinkedHashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            StringBuilder localnameBuilder = new StringBuilder();
            for (char c : parts[0].toCharArray()) {
                if (c == '+') {
                    break;
                } else if (c == '.') {

                } else {
                    localnameBuilder.append(c);
                }
            }
            address.add(localnameBuilder.toString() + "@" + parts[1]);
        }
        return address.size();
    }

    public static void main(String[] args) {
        No929UniqueEmailAddresses solution = new No929UniqueEmailAddresses();
        String[] emailAddress = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(solution.numUniqueEmails(emailAddress));
    }
}
