package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/26 11:49 下午
 */
public class No999AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int[] rookIndex = new int[2];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'R') {
                    rookIndex[0] = i;
                    rookIndex[1] = j;
                    break;
                }
            }
        }
        int result = 0;
        int j = rookIndex[1] + 1;
        while (j < board.length) {
            if (board[rookIndex[0]][j] == '.') {
                j++;
            } else if (board[rookIndex[0]][j] == 'p') {
                result++;
                break;
            } else {
                break;
            }
        }
        j = rookIndex[1] - 1;
        while (j >= 0) {
            if (board[rookIndex[0]][j] == '.') {
                j--;
            } else if (board[rookIndex[0]][j] == 'p') {
                result++;
                break;
            } else {
                break;
            }
        }
        int i = rookIndex[0] + 1;
        while (i < board[rookIndex[1]].length) {
            if (board[i][rookIndex[1]] == '.') {
                i++;
            } else if (board[i][rookIndex[1]] == 'p') {
                result++;
                break;
            } else {
                break;
            }
        }
        i = rookIndex[0] - 1;
        while (i >= 0) {
            if (board[i][rookIndex[1]] == '.') {
                i--;
            } else if (board[i][rookIndex[1]] == 'p') {
                result++;
                break;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No999AvailableCapturesForRook solution = new No999AvailableCapturesForRook();
        char[][] inputs = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'p', '.', 'p', '.'},
                {'.', 'p', '.', '.', '.', '.', '.', '.'},
                {'.', 'p', 'B', '.', 'R', '.', 'B', 'p'},
                {'.', 'p', '.', '.', '.', 'B', '.', '.'},
                {'.', '.', 'p', '.', '.', 'p', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(solution.numRookCaptures(inputs));
    }
}
