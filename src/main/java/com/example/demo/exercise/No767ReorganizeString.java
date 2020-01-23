package com.example.demo.exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/20 11:39 下午
 */
public class No767ReorganizeString {
    private class MultiChar {
        int count;
        char letter;

        public MultiChar(int count, char c) {
            this.count = count;
            this.letter = c;
        }
    }

    public String reorganizeString(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<MultiChar> priorityQueue = new PriorityQueue<>(new Comparator<MultiChar>() {
            @Override
            public int compare(MultiChar o1, MultiChar o2) {
                if (o1.count == o2.count) {
                    return o1.letter - o2.letter;
                } else {
                    return o2.count - o1.count;
                }
            }
        });
        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                if (count[i] > (N + 1) / 2) {
                    return "";
                }
                priorityQueue.add(new MultiChar(count[i], (char) ('a' + i)));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (priorityQueue.size() >= 2) {
            MultiChar mc1 = priorityQueue.poll();
            MultiChar mc2 = priorityQueue.poll();

            stringBuilder.append(mc1.letter);
            stringBuilder.append(mc2.letter);
            if (--mc1.count > 0) {
                priorityQueue.add(mc1);
            }
            if (--mc2.count > 0) {
                priorityQueue.add(mc2);
            }
        }
        if (priorityQueue.size() > 0) {
            stringBuilder.append(priorityQueue.poll().letter);
        }
        return stringBuilder.toString();
    }
}
