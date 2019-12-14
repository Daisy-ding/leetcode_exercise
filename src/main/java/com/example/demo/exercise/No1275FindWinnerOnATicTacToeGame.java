package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/4 2:39 上午
 */
public class No1275FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        char[][] cheese = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        for (int i = 0; i < moves.length; ++i) {
            int[] move = moves[i];
            if (i % 2 == 0) {
                cheese[move[0]][move[1]] = 'X';
            } else {
                cheese[move[0]][move[1]] = 'O';
            }
        }

        for (int i = 0; i < 3; ++i) {
            if (cheese[i][0] == ' ') {
                continue;
            }
            boolean equal = true;
            char base = cheese[i][0];
            for (int j = 1; j < 3; ++j) {
                if (cheese[i][j] != base) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                return base == 'X' ? "A" : "B";
            }
        }
        for (int j = 0; j < 3; ++j) {
            if (cheese[0][j] == ' ') {
                continue;
            }
            boolean equal = true;
            char base = cheese[0][j];
            for (int i = 1; i < 3; ++i) {
                if (cheese[i][j] != base) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                return base == 'X' ? "A" : "B";
            }
        }
        if (cheese[0][0] != ' ' && cheese[0][0] == cheese[1][1] && cheese[1][1] == cheese[2][2]) {
            return cheese[1][1] == 'X' ? "A" : "B";
        }
        if (cheese[2][0] != ' ' && cheese[2][0] == cheese[1][1] && cheese[1][1] == cheese[0][2]) {
            return cheese[1][1] == 'X' ? "A" : "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    public static void main(String[] args) {
        No1275FindWinnerOnATicTacToeGame solution = new No1275FindWinnerOnATicTacToeGame();
        int[][] moves = new int[][]{{0, 0}, {1, 1}};
        System.out.println(solution.tictactoe(moves));
    }
}
