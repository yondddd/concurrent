package com.yond.athread.thread;

public class ReadStackLog4 {


    public static void main(String[] args) {
        new Thread(new TimeWaitting(), "timeWaiting").start();
        new Thread(new Waitting(), "waiting").start();
        new Thread(new ThreadBlock(), "threadBlock1").start();
        new Thread(new ThreadBlock(), "threadBlock2").start();
    }


}


class TimeWaitting implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Waitting implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Waitting.class) {
                try {
                    Waitting.class.wait();
                } catch (InterruptedException e) {

                }
            }
        }
    }
}


class ThreadBlock implements Runnable{
    @Override
    public void run() {
        while (true) {
            synchronized (ThreadBlock.class) {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}