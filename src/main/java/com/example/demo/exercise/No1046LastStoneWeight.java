package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/27 11:46 下午
 */
public class No1046LastStoneWeight {
    private int[] topTwoWeightIndex(int[] stones) {
        int maxIndex = stones[0] > stones[1] ? 0 : 1;
        int secondMaxIndex = maxIndex == 0 ? 1 : 0;
        int i = 2;
        while (i < stones.length) {
            if (stones[i] > stones[maxIndex]) {
                secondMaxIndex = maxIndex;
                maxIndex = i;
            } else if (stones[i] > stones[secondMaxIndex]) {
                secondMaxIndex = i;
            }
            i++;
        }
        return new int[]{maxIndex, secondMaxIndex};
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        int[] topStoneIndex = topTwoWeightIndex(stones);
        while (stones[topStoneIndex[0]] > 0 && stones[topStoneIndex[1]] > 0) {
            stones[topStoneIndex[0]] -= stones[topStoneIndex[1]];
            stones[topStoneIndex[1]] = 0;
            topStoneIndex = topTwoWeightIndex(stones);
        }
        return stones[topStoneIndex[0]];
    }

    public static void main(String[] args) {
        No1046LastStoneWeight solution = new No1046LastStoneWeight();
        int[] stones = new int[]{1, 2};
        System.out.println(solution.lastStoneWeight(stones));
    }
}
