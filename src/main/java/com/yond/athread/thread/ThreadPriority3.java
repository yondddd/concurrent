package com.yond.athread.thread;

public class ThreadPriority3 {


    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread("thread one");
        myThread.setPriority(10);
        MyThread myThread2 = new MyThread("thread two");
        myThread2.setPriority(1);
        myThread.start();
        myThread2.start();
        Thread.sleep(1000);
        myThread2.join();
    }



}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "_" + thread.getPriority() + "_" + i);
        }
    }


}

