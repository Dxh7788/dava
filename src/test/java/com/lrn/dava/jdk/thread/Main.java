package com.lrn.dava.jdk.thread;

/**
 * @author dongxiaohong on 2018/10/12 17:25
 */
public class Main {
    private static int MY_INT = 0;
    public static void main(String[] args) {

        //创建两个线程来改变dThread的值
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                int localValue = MY_INT;
                while (localValue<5){
                    System.out.println("Got Change for MY_INT:"+MY_INT);
                    localValue = MY_INT;
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                int localValue = MY_INT;
                while (MY_INT<5){
                    System.out.println("Incrementing MY_INT to:"+ (localValue+1) );
                    MY_INT = ++localValue;
                    try {
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
