package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/20 9:29 上午
 */
public class No547FriendCircles {
    public void dfs(boolean[] visited, int[][] M, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j = 0; j < visited.length; ++j) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(visited, M, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        int result = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (visited[i]) {
                continue;
            }
            dfs(visited, M, i);
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        No547FriendCircles no547FriendCircles = new No547FriendCircles();
        int[][] M = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };
        System.out.println(no547FriendCircles.findCircleNum(M));
    }
}
