package com.epam.server;


public class Main {

    public static void main(String[] args) throws Throwable {

        Server webServer = new Server(8081);
        webServer.start();


    }
}