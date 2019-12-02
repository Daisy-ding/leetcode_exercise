package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/1 8:15 下午
 */
public class No705DesignHashSet {
    class MyHashSet {
        private int[] data;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            data = new int[1000001];
        }

        public void add(int key) {
            data[key] = 1;
        }

        public void remove(int key) {
            data[key] = 0;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return data[key] == 1;
        }
    }
}
