package com.epam.bean;

import com.epam.controller.Controller;
import com.epam.controller.Executor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Response {


    private Map<String, String> requestHeaderFields;
    private Request request;
    private OutputStream output;


    public Response(OutputStream output) {
        this.output=output;
        requestHeaderFields = new HashMap<String, String>();
    }

    public void sendToController() throws IOException {

        String method = requestHeaderFields.get("Method");
        System.out.println(method);
        Controller controller = new Controller();
        Executor executor = controller.executeMethod(method);
        executor.execute();

    }

    public void setRequest(Request request) {requestHeaderFields = request.getHeaderFields();}






}
