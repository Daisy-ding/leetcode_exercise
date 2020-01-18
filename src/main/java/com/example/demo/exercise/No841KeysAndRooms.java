package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/16 11:28 下午
 */
public class No841KeysAndRooms {
    private boolean[] marked;
    private List<List<Integer>> rooms;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        marked = new boolean[rooms.size()];
        this.rooms = rooms;
        marked[0] = true;
        dfs(0);
        int count = 0;
        for (int i = 0; i < marked.length; ++i) {
            if (marked[i]) {
                count++;
            }
        }
        return count == rooms.size();
    }

    private void dfs(int i) {
        List<Integer> keys = rooms.get(i);
        for (Integer roomKey : keys) {
            marked[roomKey] = true;
            for (Integer rk : rooms.get(roomKey)) {
                if (marked[rk]) {
                    continue;
                }
                marked[rk] = true;
                dfs(rk);
            }
        }
    }

    public static void main(String[] args) {
        No841KeysAndRooms solution = new No841KeysAndRooms();
        List<List<Integer>> inputs = new ArrayList<>();
        List<Integer> input0 = new ArrayList<>();
        input0.add(1);
        List<Integer> input1 = new ArrayList<>();
        input1.add(2);
        List<Integer> input2 = new ArrayList<>();
        input2.add(3);
        List<Integer> input3 = new ArrayList<>();
        inputs.add(input0);
        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);
        System.out.println(solution.canVisitAllRooms(inputs));
    }
}
