package com.epam.server;


public class Main {

    public static void main(String[] args) throws Throwable {

        Server webServer = new Server(8085);
        webServer.start();


    }
}