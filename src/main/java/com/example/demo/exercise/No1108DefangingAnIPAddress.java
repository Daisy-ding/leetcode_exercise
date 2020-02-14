package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/23 1:56 上午
 */
public class No1108DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        String[] pars = address.split("\\.");

        return String.join("[.]", pars);
    }

    public static void main(String[] args) {
        String input = "11.111.1.1";

        System.out.println(new No1108DefangingAnIPAddress().defangIPaddr(input));
    }
}
