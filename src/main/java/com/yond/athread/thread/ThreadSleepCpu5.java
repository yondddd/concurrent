package com.yond.athread.thread;


public class ThreadSleepCpu5 {


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new SubThread(), "My Thread" + i);
            thread.start();
        }
    }




    static class SubThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
