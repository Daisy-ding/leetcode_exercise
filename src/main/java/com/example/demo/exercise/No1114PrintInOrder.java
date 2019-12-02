package com.example.demo.exercise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/1 8:34 下午
 */
public class No1114PrintInOrder {
    class Foo {
        private final Semaphore bSem = new Semaphore(1);
        private final Semaphore cSem = new Semaphore(1);

        public Foo() {
            bSem.drainPermits();
            cSem.drainPermits();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            bSem.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            bSem.acquire();
            printSecond.run();
            cSem.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            cSem.acquire();
            printThird.run();
        }
    }

}
