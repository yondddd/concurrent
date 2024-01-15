package com.yond.athread.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Date 2024/1/14
 * @Author yond
 * @Description piped in and out
 */
public class PipedThread7 {


    public static void main(String[] args) throws IOException {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();
        try {
            out.connect(in);
            Thread thread = new Thread(new Print(in), "print-thread");
            thread.start();
            int receive = 0;
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } catch (Exception e) {

        }finally {
            out.close();
        }
    }


    static class Print implements Runnable {
        private PipedReader printIn;

        private Print(PipedReader in) {
            printIn = in;
        }

        @Override
        public void run() {
            try {
                int receive = 0;
                while ((receive = printIn.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (Exception e) {

            }

        }

    }
}
