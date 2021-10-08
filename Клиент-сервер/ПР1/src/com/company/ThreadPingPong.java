package com.company;

public class ThreadPingPong extends Thread{
    static final Object monitor = new Object();
    static volatile int count = 0;

    public ThreadPingPong(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (monitor){
            while(count<10){
                monitor.notify();
                System.out.println(this.getName());
                count++;
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
