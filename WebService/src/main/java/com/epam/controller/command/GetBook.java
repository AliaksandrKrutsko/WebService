package com.epam.controller.command;


import com.epam.bean.Book;
import com.epam.bean.ResponseHeader;
import com.epam.method.BookMaker;
import com.epam.utils.Converter;

import java.io.IOException;

public class GetBook implements com.epam.controller.Executor {



//    @GET
//    @Path("/get")
//    @Produces("application/json")
    public String execute() throws IOException {


        String body = "";

        ResponseHeader rp = new ResponseHeader();

        rp.setVersion("http 1.0");
        rp.setStatusCode("200");
        rp.setContentType("Content-Type");

        Book book;
        BookMaker bookMaker = new BookMaker();
        book = bookMaker.getBook(0);


        body = Converter.toJson(book);
        rp.setContentLength(String.valueOf(body.getBytes().length));
        rp.setBody(body);

        return rp.write();

    }

}

