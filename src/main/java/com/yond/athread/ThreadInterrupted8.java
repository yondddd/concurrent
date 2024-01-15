package com.yond.athread;

import java.util.concurrent.TimeUnit;

/**
 * @Date 2024/1/15
 * @Author yond
 * @Description
 */
public class ThreadInterrupted8 {


    public static void main(String[] args) throws InterruptedException {
        Thread sleep = new Thread(new SleepRunner(), "Sleep-Thread");
        Thread busy = new Thread(new BusyRunner(), "Busy-Thread");
        sleep.setDaemon(true);
        busy.setDaemon(true);
        sleep.start();
        busy.start();
        sleep.interrupt();
        busy.interrupt();
        System.out.println(sleep.getName() + ":" + sleep.isInterrupted());
        System.out.println(busy.getName() + ":" +busy.isInterrupted());
        TimeUnit.SECONDS.sleep(5);

    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {

            }
        }

    }
}
