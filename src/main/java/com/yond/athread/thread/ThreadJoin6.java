package com.yond.athread.thread;

public class ThreadJoin6 {

    public static Object lock = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new NoRelease(), "Thread-No" + i);
            thread.start();
        }
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new Release(), "Thread-Yes" + i);
            thread.start();
        }
    }

    static class NoRelease implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Release implements Runnable {
        @Override
        public void run() {
            synchronized (Thread.currentThread()) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
