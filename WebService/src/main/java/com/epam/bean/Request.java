package com.epam.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {



    private InputStream input;
    private List<String> body;
    private Map<String, String> headerFields;

    public Request(InputStream input) {
        this.input = input;
        body = new ArrayList<String>();
        headerFields = new HashMap<String, String>();
    }

    public void parse() {

        List<String> header = new ArrayList<String>();
        String[] str = flushBuffer();
        int i = 0;
        boolean flag = false;
        while (i < str.length) {
            if (str[i].isEmpty()) {
                i++;
                flag = true;
            }
            if (!flag) {
                header.add(str[i]);
            }
            i++;
        }
        headerFields.put("Method", getMethod(header.get(0).trim()));

    }

    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');

        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2);
        }

        return null;
    }


    private String[] flushBuffer() {
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            request.append((char) buffer[j]);
        }

        return request.toString().split("\r\n");
    }

    private String getMethod(String str) {
        int to = str.indexOf(" ");
        return str.substring(0, to);
    }

    public Map<String, String> getHeaderFields() {
        return headerFields;
    }


}
