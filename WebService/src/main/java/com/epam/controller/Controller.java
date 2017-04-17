package com.epam.controller;


import com.epam.controller.command.GetBook;

import java.io.IOException;

public class Controller {

    public void executeMethod(String method) throws IOException {

        switch (method.toUpperCase()) {
            case "GET":
                GetBook getBook = new GetBook();
                getBook.execute();
                break;
        }

    }
}
