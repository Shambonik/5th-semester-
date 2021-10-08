package com.company;

public class Main {

    public static void main (String[]args) throws InterruptedException {
        ThreadPingPong ping = new ThreadPingPong("ping");
        ThreadPingPong pong = new ThreadPingPong("pong");

        ping.setDaemon(true);
        pong.setDaemon(true);

        ping.start();
        pong.start();

        Thread.sleep(2000);
    }
}
