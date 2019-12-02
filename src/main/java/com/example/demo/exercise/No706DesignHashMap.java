package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/1 8:10 下午
 */
public class No706DesignHashMap {
    class MyHashMap {
        private int[] data;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            data = new int[1000001];
            Arrays.fill(data, -1);
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            data[key] = value;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            return data[key];
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            data[key] = -1;
        }
    }
}
