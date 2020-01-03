package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/3 11:45 下午
 */
public class No93RestoreIPAddresses {
    private List<String> results = new ArrayList<>();
    private String s;

    private boolean validStr(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int value = Integer.parseInt(s);
        return value >= 0 && value <= 255;
    }

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        if (s.equals("0000")) {
            results.add("0.0.0.0");
            return results;
        }
        dfs("", 0);
        return this.results;
    }

    private void dfs(String currentIPString, int partsCount) {
        if (partsCount >= 4) {
            return;
        }
        String removeDotStr = currentIPString.replaceAll("\\.", "");
        if (removeDotStr.length() == s.length()) {
            return;
        }
        for (int i = 1; i <= 3; ++i) {
            if (removeDotStr.length() + i > s.length()) {
                continue;
            }
            String subStr = s.substring(removeDotStr.length(), removeDotStr.length() + i);
            if (!validStr(subStr)) {
                continue;
            }
            if (partsCount == 3) {
                String newString = currentIPString + subStr;
                if (newString.length() == s.length() + 3) {
                    results.add(newString);
                }
            } else {
                String newString = currentIPString + subStr + ".";
                dfs(newString, partsCount + 1);
            }
        }
    }

    public static void main(String[] args) {
        No93RestoreIPAddresses solution = new No93RestoreIPAddresses();
        List<String> results = solution.restoreIpAddresses("127001");
        for (String s : results) {
            System.out.println(s);
        }
    }
}
