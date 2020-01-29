package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/29 10:57 下午
 */
public class No809ExpressiveWords {
    private class MultiChar {
        char c;
        int count;

        public MultiChar(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    private List<MultiChar> divide(String word) {
        if (word.length() == 0) {
            return new ArrayList<>();
        }
        char lastChar = word.charAt(0);
        List<MultiChar> result = new ArrayList<>();
        result.add(new MultiChar(lastChar, 1));
        for (int i = 1; i < word.length(); ++i) {
            char currentChar = word.charAt(i);
            if (lastChar == currentChar) {
                result.get(result.size() - 1).count++;
            } else {
                result.add(new MultiChar(currentChar, 1));
                lastChar = currentChar;
            }
        }
        return result;
    }

    private boolean isExpressiveWord(List<MultiChar> sList, List<MultiChar> wordList) {
        if (sList.size() != wordList.size()) {
            return false;
        }
        int n = sList.size();
        for (int i = 0; i < n; ++i) {
            MultiChar mc1 = sList.get(i);
            MultiChar mc2 = wordList.get(i);
            if (mc1.c != mc2.c) {
                return false;
            }
            if (mc1.count != mc2.count) {
                if (mc2.count < 3 && mc1.count < 3) {
                    return false;
                }
                if (mc1.count < mc2.count) {
                    return false;
                }
            }
        }
        return true;
    }

    public int expressiveWords(String S, String[] words) {
        List<MultiChar> sList = divide(S);
        int count = 0;
        for (String word : words) {
            List<MultiChar> wordList = divide(word);
            if (isExpressiveWord(sList, wordList)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No809ExpressiveWords solution = new No809ExpressiveWords();
        String[] words = {"ggkyyfbbhdrxxsiixccqkmmiiivvvyyujccuuuhhwsnnttoyuuussggtttfeeebbbeedddqq"};
        System.out.println(solution.expressiveWords("ggkyyyyffffbbhddddrxxsiixccqqqqkmmmiiiiiivvvyyuuujccuuuhhhhwssssnnttoyuuuussggttttfeeeebbbbeedddddqq", words));
    }
}
