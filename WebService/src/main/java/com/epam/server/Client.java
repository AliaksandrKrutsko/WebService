package com.epam.server;


import com.epam.bean.Request;
import com.epam.bean.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable {

    private Request request;
    private Response response;
    private Socket socket;
    private InputStream input = null;
    private OutputStream output = null;

    public Client(Socket socket) throws IOException {
        this.socket=socket;
        initialize();
    }

    public void initialize() throws IOException {
        input = socket.getInputStream();
        output = socket.getOutputStream();
    }

    public void run() {

        request = new Request(input);
        request.parse();
        response = new Response(output);
        response.setRequest(request);
        try {
            response.sendToController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
