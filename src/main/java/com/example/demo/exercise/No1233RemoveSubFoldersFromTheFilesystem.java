package com.example.demo.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/27 11:13 下午
 */
public class No1233RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> results = new LinkedList<>();
        for (String s : folder) {
            boolean isSubFolder = true;
            for (String f : results) {
                if (s.startsWith(f) && s.charAt(f.length()) == '/') {
                    isSubFolder = false;
                    break;
                }
            }
            if (isSubFolder) {
                results.add(s);
            }
        }
        return results;
    }
}
