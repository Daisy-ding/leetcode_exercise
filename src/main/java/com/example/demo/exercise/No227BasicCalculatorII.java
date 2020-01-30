package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/30 10:48 下午
 */
public class No227BasicCalculatorII {

    public int calculate(String s) {
        Map<Character, Integer> opPriorityMap = new HashMap<>();
        opPriorityMap.put('+', 1);
        opPriorityMap.put('-', 1);
        opPriorityMap.put('*', 2);
        opPriorityMap.put('/', 2);
        List<String> postOrderSequence = new ArrayList<>();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < s.length()) {
            char current = s.charAt(i);
            if (current == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(current)) {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i++));
                }
                postOrderSequence.add(sb.toString());
            } else {
                if (stack.isEmpty()) {
                    stack.push(current);
                } else {
                    int currentPriority = opPriorityMap.get(current);
                    int topNodePriority = opPriorityMap.get(stack.peek());
                    if (currentPriority > topNodePriority) {
                        stack.push(current);
                    } else {
                        while (!stack.isEmpty() && opPriorityMap.get(stack.peek()) >= currentPriority) {
                            postOrderSequence.add(stack.pop().toString());
                        }
                        stack.push(current);
                    }
                }
                i++;
            }
        }
        while (!stack.isEmpty()) {
            postOrderSequence.add(stack.pop().toString());
        }

        Stack<String> calculateStack = new Stack<>();
        for (String str : postOrderSequence) {
            if (Character.isDigit(str.charAt(0))) {
                calculateStack.push(str);
            } else {
                int second = Integer.valueOf(calculateStack.pop());
                int first = Integer.valueOf(calculateStack.pop());
                int result = 0;
                switch (str) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                    default:
                }
                calculateStack.push("" + result);
            }
        }
        return Integer.valueOf(calculateStack.pop());
    }

    public static void main(String[] args) {
        No227BasicCalculatorII solution = new No227BasicCalculatorII();
        System.out.println(solution.calculate("1-1*2-1-1"));
    }
}
