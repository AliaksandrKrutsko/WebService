package com.epam.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int port;

    public Server(int port) throws Throwable {

        this.port = port;
    }

    public void start() throws Throwable {
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            Socket socket = ss.accept();
            Client client = new Client(socket);
            client.run();
            socket.close();
        }
    }
}
