package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/29 10:53 下午
 */
public class No682BaseballGame {
    public int calPoints(String[] ops) {
        int result = 0;
        List<Integer> points = new LinkedList<>();
        for (String op : ops) {
            if (op.equals("C")) {
                int point = points.remove(points.size() - 1);
                result -= point;
            } else if (op.equals("D")) {
                int point = points.get(points.size() - 1) * 2;
                points.add(point);
                result += point;
            } else if (op.equals("+")) {
                int point = points.get(points.size() - 1) + points.get(points.size() - 2);
                points.add(point);
                result += point;
            } else {
                int point = Integer.valueOf(op);
                points.add(point);
                result += point;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No682BaseballGame solution = new No682BaseballGame();
        String[] inputs = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(solution.calPoints(inputs));
    }
}
