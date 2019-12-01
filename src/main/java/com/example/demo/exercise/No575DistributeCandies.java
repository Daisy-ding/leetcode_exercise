package com.example.demo.exercise;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/30 3:36 下午
 */
public class No575DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> kindSet = new LinkedHashSet<>();
        for (int candy : candies) {
            if (kindSet.size() == candies.length / 2) {
                break;
            }
            kindSet.add(candy);
        }
        return kindSet.size();
    }
}
