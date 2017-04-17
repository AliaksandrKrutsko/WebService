package com.epam.bean;

import com.epam.controller.Controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Response {

    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator  + "webroot";
    private static final int BUFFER_SIZE = 2048;
    private Map<String, String> requestHeaderFields;
    private Request request;
    private OutputStream output;


    public Response(OutputStream output) {
        this.output=output;
        requestHeaderFields = new HashMap<String, String>();
    }



    public void send() throws IOException {

        String method = requestHeaderFields.get("Method");
        System.out.println(method);
        Controller controller = new Controller();
        controller.executeMethod(method);

    }

    public void setRequest(Request request) {this.request=request;}






}
