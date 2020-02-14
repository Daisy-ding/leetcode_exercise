package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/12/28 10:50 下午
 */
public class No925LongPressedName {
    private static class Element {
        char c;
        int count;
    }

    private List<Element> calculateElementList(String str) {
        List<Element> elements = new ArrayList<>();
        Element element = new Element();
        element.c = str.charAt(0);
        element.count = 1;
        elements.add(element);
        for (int i = 1; i < str.length(); ++i) {
            Element lastOne = elements.get(elements.size() - 1);
            if (lastOne.c == str.charAt(i)) {
                lastOne.count++;
            } else {
                Element newOne = new Element();
                newOne.c = str.charAt(i);
                newOne.count = 1;
                elements.add(newOne);
            }
        }
        return elements;
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        List<Element> nameElements = calculateElementList(name);
        List<Element> typedElements = calculateElementList(typed);
        if (nameElements.size() != typedElements.size()) {
            return false;
        }
        for (int i = 0; i < nameElements.size(); ++i) {
            Element nameElement = nameElements.get(i);
            Element typedElement = typedElements.get(i);
            if (nameElement.c != typedElement.c || nameElement.count > typedElement.count) {
                return false;
            }
        }
        return true;
    }
}
