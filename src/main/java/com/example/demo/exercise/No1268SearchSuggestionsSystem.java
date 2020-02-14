package com.example.demo.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/27 10:21 下午
 */
public class No1268SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> results = new LinkedList<>();
        for (int i = 0; i < searchWord.length(); ++i) {
            String prefix = searchWord.substring(0, i + 1);
            List<String> result = new LinkedList<>();
            int j = 0;
            while (j < products.length && result.size() < 3) {
                if (products[j].startsWith(prefix)) {
                    result.add(products[j]);
                }
                j++;
            }
            results.add(result);
        }
        return results;
    }
}
