package com.epam.controller.command;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GetBook implements com.epam.controller.Executor {


    private static final int BUFFER_SIZE = 1024;
    private int id;
    private OutputStream output;

//    @GET
//    @Path("/get")
//    @Produces("application/json")
    public void execute() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {

            File file = new File("src\\main\\resources\\book.xml");
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);

                while (ch != -1) {
                    output.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            }
            else {
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            }
        }
        catch (Exception e) {
            System.out.println(e.toString() );
        }
        finally {
            if (fis != null)
                fis.close();
        }



    }

}

