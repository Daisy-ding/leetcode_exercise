package com.example.demo.exercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yubang
 * @date 2020/1/27 10:02 下午
 */
public class No609FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentPathListMap = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            for (int i = 1; i < parts.length; ++i) {
                String fileNameWithContent = parts[i];
                String fileName = fileNameWithContent.substring(0, fileNameWithContent.indexOf('('));
                String content = fileNameWithContent.substring(fileNameWithContent.lastIndexOf('(') + 1, fileNameWithContent.length() - 1);
                if (!contentPathListMap.containsKey(content)) {
                    contentPathListMap.put(content, new LinkedList<>());
                }
                contentPathListMap.get(content).add(parts[0] + '/' + fileName);
            }
        }
        List<List<String>> results = new LinkedList<>();
        for (List<String> list : contentPathListMap.values()) {
            if (list.size() > 1) {
                results.add(list);
            }
        }
        return results;
    }
}
