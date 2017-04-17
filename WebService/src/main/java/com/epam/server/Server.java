package com.epam.server;

import com.epam.bean.Request;
import com.epam.bean.Response;

import java.io.InputStream;
import java.io.OutputStream;
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
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            Request request = new Request(input);
            request.parse();
            Response response = new Response(output);
            response.setRequest(request);
            response.send();
            socket.close();

        }
    }
}
