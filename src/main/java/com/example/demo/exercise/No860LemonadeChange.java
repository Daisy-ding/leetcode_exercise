package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/8 5:29 下午
 */
public class No860LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount == 0) {
                    return false;
                }
                tenCount++;
                fiveCount--;
            } else if (bill == 20) {
                if (tenCount >= 1 && fiveCount >= 1) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No860LemonadeChange solution = new No860LemonadeChange();
        int[] bills = new int[]{5, 5, 5, 5, 20, 20, 5, 5, 5, 5};
        System.out.println(solution.lemonadeChange(bills));
    }
}
