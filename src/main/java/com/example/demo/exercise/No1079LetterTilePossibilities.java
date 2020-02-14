package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/2 10:35 下午
 */
public class No1079LetterTilePossibilities {

    public int numTilePossibilities(String tiles) {
        int[] buckets = new int[26];
        for (char c : tiles.toCharArray()) {
            buckets[c - 'A']++;
        }
        return dfs(buckets);
    }

    private int dfs(int[] buckets) {
        int result = 0;
        for (int i = 0; i < 26; ++i) {
            if (buckets[i] == 0) {
                continue;
            }
            result += 1;
            buckets[i] -= 1;

            result += dfs(buckets);
            buckets[i] += 1;
        }
        return result;
    }
}
