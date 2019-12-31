package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/1 12:38 上午
 */
public class No914XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> cardsCountMap = new HashMap<>();
        for (int card : deck) {
            if (cardsCountMap.containsKey(card)) {
                cardsCountMap.put(card, cardsCountMap.get(card) + 1);
            } else {
                cardsCountMap.put(card, 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int count : cardsCountMap.values()) {
            min = Math.min(min, count);
        }
        if (min == 1) {
            return false;
        }
        for (int i = 2; i <= min; ++i) {
            boolean canPartition = true;
            for (int count : cardsCountMap.values()) {
                if (count % i != 0) {
                    canPartition = false;
                }
            }
            if (canPartition) {
                return true;
            }
        }
        return false;
    }
}
