package com.example.demo.exercise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 2:36 下午
 */
public class No933NumberOfRecentCalls {
    public class RecentCounter {
        private List<Integer> last3SecondsCalls;

        public RecentCounter() {
            last3SecondsCalls = new LinkedList<>();
        }

        public int ping(int t) {
            Iterator<Integer> it = last3SecondsCalls.iterator();
            while (it.hasNext()) {
                int value = it.next().intValue();
                if (t - value > 3000) {
                    it.remove();
                } else {
                    break;
                }
            }
            last3SecondsCalls.add(t);
            return last3SecondsCalls.size();
        }
    }
}
