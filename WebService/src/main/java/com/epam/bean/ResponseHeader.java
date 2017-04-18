package com.epam.bean;


import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHeader {


    private String version;
    private String statusCode;
    private String server;
    private String date;
    private String contentType;
    private String contentLength;
    private String body;

    public ResponseHeader() {

    }

    public String write() {

        String response = "";
        Map<String, String> responseMap = new LinkedHashMap<String, String>();

        responseMap.put(version, statusCode);

        responseMap.put("Server:", "MyServer \n");

        if (!contentType.isEmpty()) {
            responseMap.put("Content-Type", contentType + "\r\n");
        }

        if (!contentLength.isEmpty()) {
            responseMap.put("Content-Lenght", contentLength + "\r\n");
        }

        responseMap.put("Connection", "close\n" +
                "\n");

        if (!body.isEmpty()) {
            responseMap.put("body", body);
        }

        for (Map.Entry<String, String> pair : responseMap.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            response += key + value;
        }
        return response;

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    private String connection;

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }








}
