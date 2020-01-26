package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/26 10:18 下午
 */
public class No165CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        int minSize = Math.min(parts1.length, parts2.length);
        for (int i = 0; i < minSize; ++i) {
            int part1 = Integer.valueOf(parts1[i]);
            int part2 = Integer.valueOf(parts2[i]);
            if (part1 == part2) {
                continue;
            }
            return part1 > part2 ? 1 : -1;
        }
        if (parts1.length == parts2.length) {
            return 0;
        }
        if (parts1.length == minSize) {
            boolean allZero = true;
            for (int k = minSize; k < parts2.length; ++k) {
                if (Integer.valueOf(parts2[k]) != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                return 0;
            } else {
                return -1;
            }
        }
        boolean allZero = true;
        for (int k = minSize; k < parts1.length; ++k) {
            if (Integer.valueOf(parts1[k]) != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) {
            return 0;
        } else {
            return 1;
        }
    }
}
