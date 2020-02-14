package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/11/26 10:06 下午
 */
public class No1078OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> result = new LinkedList<>();
        int i = 0;
        int j = 1;
        while (i < words.length && j < words.length) {
            if (words[i].equals(first) && words[j].equals(second)) {
                if (j + 1 < words.length) {
                    result.add(words[j + 1]);
                }
            }
            i++;
            j++;
        }
        String[] r = new String[result.size()];
        for (int k = 0; k < result.size(); ++k) {
            r[k] = result.get(k);
        }
        return r;
    }
}
