package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/19 12:38 上午
 */
public class No692TopKFrequentWords {
    private class WordCount {
        String word;
        int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            if (countMap.containsKey(word)) {
                countMap.put(word, countMap.get(word) + 1);
            } else {
                countMap.put(word, 1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int count : countMap.values()) {
            priorityQueue.add(count);
            if (priorityQueue.size() > k) {
                priorityQueue.remove(priorityQueue.peek());
            }
        }
        int kthCount = priorityQueue.peek();
        List<WordCount> wordCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= kthCount) {
                wordCounts.add(new WordCount(entry.getKey(), entry.getValue()));
            }
        }
        Collections.sort(wordCounts, new Comparator<WordCount>() {
            @Override
            public int compare(WordCount o1, WordCount o2) {
                if (o1.count == o2.count) {
                    return o1.word.compareTo(o2.word);
                } else {
                    return o2.count - o1.count;
                }
            }
        });
        List<String> results = new ArrayList<>();

        for (int i = 0; i < k; ++i) {
            results.add(wordCounts.get(i).word);
        }
        return results;
    }

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        No692TopKFrequentWords solution = new No692TopKFrequentWords();
        solution.topKFrequent(words, 2);
    }
}
