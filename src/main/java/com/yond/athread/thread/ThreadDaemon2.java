package com.yond.athread.thread;

public class ThreadDaemon2 {


    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread(), "normal");
        thread.start();
        Thread thread1 = new Thread(new MyThread(), "daemon");
        thread1.setDaemon(true);
        thread1.start();
    }

    static class MyThread implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }finally {
                System.out.println("好");
            }
        }
    }
}
