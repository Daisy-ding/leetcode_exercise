package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/23 9:02 下午
 */
public class No1138AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        Map<Character, int[]> charIndexMap = new HashMap<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length(); ++j) {
                charIndexMap.put(board[i].charAt(j), new int[]{i, j});
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int[] lastIndex = new int[]{0, 0};
        for (char c : target.toCharArray()) {
            int[] currentIndex = charIndexMap.get(c);
            if (currentIndex[0] == lastIndex[0] && currentIndex[1] == lastIndex[1]) {
                stringBuilder.append('!');
            } else {
                if (currentIndex[0] >= lastIndex[0]) {
                    // L/R first
                    if (currentIndex[1] >= lastIndex[1]) {
                        //Right
                        int rightTimes = currentIndex[1] - lastIndex[1];
                        for (int k = 0; k < rightTimes; ++k) {
                            stringBuilder.append('R');
                        }
                    } else {
                        //Left
                        int leftTime = lastIndex[1] - currentIndex[1];
                        for (int k = 0; k < leftTime; ++k) {
                            stringBuilder.append('L');
                        }
                    }
                    // then down
                    int downTimes = currentIndex[0] - lastIndex[0];
                    for (int k = 0; k < downTimes; ++k) {
                        stringBuilder.append('D');
                    }
                } else {
                    //Up First
                    int upTimes = lastIndex[0] - currentIndex[0];
                    for (int k = 0; k < upTimes; ++k) {
                        stringBuilder.append('U');
                    }
                    // L/R second
                    if (currentIndex[1] >= lastIndex[1]) {
                        //Right
                        int rightTimes = currentIndex[1] - lastIndex[1];
                        for (int k = 0; k < rightTimes; ++k) {
                            stringBuilder.append('R');
                        }
                    } else {
                        //Left
                        int leftTime = lastIndex[1] - currentIndex[1];
                        for (int k = 0; k < leftTime; ++k) {
                            stringBuilder.append('L');
                        }
                    }
                }
                stringBuilder.append('!');
                lastIndex = currentIndex;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        No1138AlphabetBoardPath solution = new No1138AlphabetBoardPath();
        System.out.println(solution.alphabetBoardPath("leet"));
    }
}
