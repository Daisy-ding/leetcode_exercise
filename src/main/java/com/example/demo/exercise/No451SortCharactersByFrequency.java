package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang
 * @date 2020/1/19 11:36 下午
 */
public class No451SortCharactersByFrequency {
    private class Element {
        char c;
        int count;

        public Element(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        List<Element> elements = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            elements.add(new Element(entry.getKey(), entry.getValue()));
        }

        Collections.sort(elements, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if (o1.count == o2.count) {
                    return o1.c - o2.c;
                } else {
                    return o2.count - o1.count;
                }
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (Element element : elements) {
            for (int i = 0; i < element.count; ++i) {
                stringBuilder.append(element.c);
            }
        }
        return stringBuilder.toString();
    }
}
