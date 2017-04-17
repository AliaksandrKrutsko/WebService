package com.epam.controller;


import com.epam.controller.command.GetBook;

import java.io.IOException;

public class Controller {

    public Executor executeMethod(String method) throws IOException {

        Executor executor = null;

        switch (method.toUpperCase()) {
            case "GET":
                executor = new GetBook();
                break;
        }
        return executor;
    }
}
