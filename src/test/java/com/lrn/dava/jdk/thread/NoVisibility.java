package com.lrn.dava.jdk.thread;

/**
 * @author dongxiaohong
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    private static class WriteThread extends Thread {
        @Override
        public void run() {
            number = 42;
            ready = true;
            Thread.yield();
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        new ReaderThread().start();
        new WriteThread().start();
    }
}