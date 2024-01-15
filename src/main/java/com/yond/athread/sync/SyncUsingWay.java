package com.yond.athread.sync;

/**
 * @Date 2024/1/22
 * @Author yond
 * @Description three using way
 */
public class SyncUsingWay {

    public synchronized void myMethod() {
        System.out.println("object method");
    }

    public static synchronized void myStaticMethod() {
        System.out.println("object static method");
    }

    public void method() {
        synchronized (this){
            System.out.println("method");
        }
    }

}
